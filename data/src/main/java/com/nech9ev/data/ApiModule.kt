package com.nech9ev.data

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object ApiModule {

    @Provides
    @Reusable
    fun provideGifApiConfig(): GifApiRouter{
        return DevLifeApiRouter()
    }

}