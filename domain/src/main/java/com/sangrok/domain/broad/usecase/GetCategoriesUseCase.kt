package com.sangrok.domain.broad.usecase

import com.sangrok.domain.broad.repository.BroadRepository
import javax.inject.Inject

class GetCategoriesUseCase @Inject constructor(
    private val repository: BroadRepository,
) {
    suspend operator fun invoke(
        clientId: String,
    ) = runCatching {
        repository.getCategories(clientId = clientId)
    }
}