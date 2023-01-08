package com.sangrok.data.broad.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.sangrok.data.broad.datasource.BroadDataSource
import com.sangrok.data.broad.dto.request.BroadRequest
import com.sangrok.data.broad.mapper.toDomain
import com.sangrok.domain.broad.model.Broad
import retrofit2.HttpException
import java.io.IOException

class BroadPagingSource(
    private val broadDataSource: BroadDataSource,
    private val request: BroadRequest
) : PagingSource<Int, Broad>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Broad> {
        return try {
            val position = params.key ?: 1
            val response = broadDataSource.getBroads(
                clientId = request.clientId,
                categoryId = request.categoryId,
                page = position
            )

            val prevKey = if (position == 1) null else position - 1
            val nextKey = if (response.broads.isEmpty()) null else position + 1

            LoadResult.Page(
                data = response.broads.map { it.toDomain() },
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Broad>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val page = state.closestPageToPosition(anchorPosition)
            page?.prevKey?.minus(1) ?: page?.nextKey?.plus(1)
        }
    }

}
