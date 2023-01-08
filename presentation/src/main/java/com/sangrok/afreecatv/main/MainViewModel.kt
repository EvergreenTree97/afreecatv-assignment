package com.sangrok.afreecatv.main

import android.util.Log
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.sangrok.afreecatv.main.screen.InitialTabIndex
import com.sangrok.core.base.BaseViewModel
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.usecase.GetBroadsUseCase
import com.sangrok.domain.broad.usecase.GetCategoriesUseCase
import com.sangrok.presentation.BuildConfig
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase,
    private val getBroadsUseCase: GetBroadsUseCase,
) : BaseViewModel<MainState, MainSideEffect>(MainState()) {


    fun getCategories() = viewModelScope.launch {
        updateState { copy(isCategoryLoading = true) }
        getCategoriesUseCase(clientId = ClientID).onSuccess { categories ->
            updateState {
                copy(
                    categories = categories.toImmutableList(),
                    isCategoryLoading = false,
                )
            }
            getBroads(categoryId = categories[InitialTabIndex].id)
        }.onFailure {
            print("카테고리 호출 실패 예외처리")
        }
    }

    fun getBroads(
        categoryId: String
    ) = viewModelScope.launch(Dispatchers.IO) {
        updateState { copy(isBroadLoading = true) }
        getBroadsUseCase(
            clientId = ClientID,
            categoryId = categoryId
        ).onSuccess { pagingDataFlow ->
            pagingDataFlow.cachedIn(viewModelScope)
                .also {
                    updateState {
                        copy(
                            broads = pagingDataFlow,
                            isBroadLoading = false
                        )
                    }
                }
        }.onFailure {
            print("방송 리스트 불러오기 실패")
        }
    }

    fun onTabSelected(index: Int) {
        getBroads(categoryId = currentState.categories[index].id)
    }

    fun onClickBroad(
        broad: Broad
    ) = viewModelScope.launch {
        postSideEffect {
            MainSideEffect.NavigateToBroadDetail(
                broad = broad
            )
        }
    }

    companion object {
        private const val ClientID = BuildConfig.CLIENT_ID
    }
}