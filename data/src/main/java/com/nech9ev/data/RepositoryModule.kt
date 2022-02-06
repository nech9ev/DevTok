package com.nech9ev.data

import com.nech9ev.domain.GifRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
abstract class RepositoryModule{

    @Singleton
    @Binds
    abstract fun bindGifRepository(impl: GifRepositoryImpl): GifRepository

}