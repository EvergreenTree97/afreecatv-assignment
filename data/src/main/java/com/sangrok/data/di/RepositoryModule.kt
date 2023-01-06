package com.sangrok.data.di

import com.sangrok.data.broad.repository.BroadRepositoryImpl
import com.sangrok.domain.broad.repository.BroadRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindBroadRepository(repository: BroadRepositoryImpl): BroadRepository
}