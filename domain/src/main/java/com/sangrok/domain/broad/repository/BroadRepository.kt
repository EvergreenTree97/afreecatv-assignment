package com.sangrok.domain.broad.repository

import androidx.paging.PagingData
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category
import kotlinx.coroutines.flow.Flow

interface BroadRepository {
    suspend fun getBroads(
        clientId: String,
        categoryId: String,
        page: Int
    ): Flow<PagingData<Broad>>

    suspend fun getCategories(
        clientId: String,
    ): List<Category>
}