package com.sangrok.domain.broad.usecase

import com.sangrok.domain.broad.repository.BroadRepository

class GetCategoriesUseCase(
    private val repository: BroadRepository,
) {
    suspend operator fun invoke(
        clientId: String,
    ) = runCatching {
        repository.getCategories(clientId = clientId)
    }
}