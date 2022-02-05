package com.nech9ev.data

import com.nech9ev.domain.model.Gif
import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
object GifsTestingModule {

    @Reusable
    @Provides
    fun provideGif(): List<Gif>{
        val simpleGif = Gif(
            description = "Test makes great again",
            votes = 239,
            author = "Igor Nechaev",
            gifUrl = "test url",
            previewUrl = "test url"
        )

        return listOf(simpleGif, simpleGif, simpleGif)
    }
}