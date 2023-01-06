package com.sangrok.afreecatv

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sangrok.domain.broad.usecase.GetCategoriesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getCategoriesUseCase: GetCategoriesUseCase
) : ViewModel() {

    init {
        getCategories()
    }

    private fun getCategories() = viewModelScope.launch {
        getCategoriesUseCase("af_mobilelab_dev_e0f147f6c034776add2142b425e81777").onSuccess {
            Log.d("성공", it[0].name)
        }.onFailure {
            Log.d("실패", it.localizedMessage)
        }
    }
}