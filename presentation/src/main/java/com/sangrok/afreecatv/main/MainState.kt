package com.sangrok.afreecatv.main

import androidx.paging.PagingData
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emptyFlow

data class MainState(
    val isCategoryLoading: Boolean = true,
    val categories: ImmutableList<Category> = persistentListOf(),
    val selectedCategoryId: String = "",
    val isBroadLoading: Boolean = true,
    val broads: Flow<PagingData<Broad>> = emptyFlow(),
)