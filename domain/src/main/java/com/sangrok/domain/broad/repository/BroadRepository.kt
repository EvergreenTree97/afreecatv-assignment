package com.sangrok.domain.broad.repository

import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category

interface BroadRepository {
    suspend fun getBroads(
        clientId: String,
        categoryId: String,
        page: Int
    ): List<Broad>

    suspend fun getCategories(
        clientId: String,
    ): List<Category>
}