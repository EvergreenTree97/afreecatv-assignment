package com.sangrok.domain.broad.usecase

import com.sangrok.domain.broad.repository.BroadRepository
import javax.inject.Inject

class GetBroadsUseCase @Inject constructor(
    private val repository: BroadRepository
) {
    suspend operator fun invoke(
        clientId: String,
        categoryId: String,
    ) = runCatching{
        repository.getBroads(
            clientId = clientId,
            categoryId = categoryId,
        )
    }
}