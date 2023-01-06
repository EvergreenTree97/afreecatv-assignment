package com.sangrok.domain.broad.usecase

import com.sangrok.domain.broad.repository.BroadRepository

class GetBroadsUseCase(
    private val repository: BroadRepository
) {
    suspend operator fun invoke(
        clientId: String,
        categoryId: String,
        page: Int
    ) = runCatching{
        repository.getBroads(
            clientId = clientId,
            categoryId = categoryId,
            page = page,
        )
    }
}