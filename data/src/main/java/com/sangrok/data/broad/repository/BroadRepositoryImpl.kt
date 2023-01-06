package com.sangrok.data.broad.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.sangrok.data.broad.datasource.BroadDataSource
import com.sangrok.data.broad.dto.request.BroadRequest
import com.sangrok.data.broad.mapper.toDomain
import com.sangrok.data.broad.paging.BroadPagingSource
import com.sangrok.domain.broad.model.Broad
import com.sangrok.domain.broad.model.Category
import com.sangrok.domain.broad.repository.BroadRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class BroadRepositoryImpl @Inject constructor(
    private val broadDataSource: BroadDataSource,
) : BroadRepository {
    override suspend fun getBroads(
        clientId: String,
        categoryId: String,
        page: Int
    ): Flow<PagingData<Broad>> {
        return Pager(
            config = PagingConfig(pageSize = 6),
            pagingSourceFactory = {
                BroadPagingSource(
                    broadDataSource = broadDataSource,
                    request = BroadRequest(clientId, categoryId, page)
                )
            }
        ).flow
    }

    override suspend fun getCategories(clientId: String): List<Category> {
        return broadDataSource.getCategories(clientId).toDomain()
    }
}