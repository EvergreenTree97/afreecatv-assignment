package com.sangrok.data.api

import com.sangrok.data.broad.dto.response.BroadResponse
import com.sangrok.data.broad.dto.response.CategoryResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface AfreecaTvApi {
    @GET("broad/list")
    suspend fun getBroads(
        @Query("client_id") clientId: String,
        @Query("select_Value") categoryId: String,
        @Query("page_no") page: Int,
    ): BroadResponse

    @GET("broad/category/list")
    suspend fun getCategories(
        @Query("client_id") clientId: String,
    ): CategoryResponse
}