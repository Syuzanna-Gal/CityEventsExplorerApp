package com.example.data.di


import com.example.data.repository.EventsRepositoryImpl
import com.example.domain.repository.EventsRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCategoryRepository(impl: EventsRepositoryImpl): EventsRepository
}