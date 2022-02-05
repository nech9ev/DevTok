package com.nech9ev.data.datasource

import com.nech9ev.core.GifCategory
import com.nech9ev.data.model.GifDTO
import com.nech9ev.data.model.GifResponse

interface GifDataSource {

    suspend fun fetchGitPage(category: GifCategory, page: Int): GifResponse

    suspend fun fetchRandomGif(): GifDTO

}