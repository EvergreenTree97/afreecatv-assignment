package com.sangrok.data.broad.datasource


import com.sangrok.data.api.AfreecaTvApi
import com.sangrok.data.broad.dto.response.BroadResponse
import com.sangrok.data.broad.dto.response.CategoryResponse
import javax.inject.Inject

class BroadDataSource @Inject constructor(
    private val afreecaTvApi: AfreecaTvApi
) {
    suspend fun getCategories(clientId: String): CategoryResponse {
        return afreecaTvApi.getCategories(clientId = clientId)
    }
    suspend fun getBroads(
        clientId: String,
        categoryId: String,
        page: Int
    ): BroadResponse {
        return afreecaTvApi.getBroads(
            clientId = clientId,
            categoryId = categoryId,
            page = page,
        )
    }
}