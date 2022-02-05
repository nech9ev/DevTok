package com.nech9ev.data.datasource

import com.nech9ev.core.GifCategory
import com.nech9ev.data.api.GifApiRouter
import com.nech9ev.data.model.GifDTO
import com.nech9ev.data.model.GifResponse
import io.ktor.client.*
import io.ktor.client.request.*
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
open class GifDataSourceImpl @Inject constructor(
    private val client: HttpClient,
    private val apiRouter: GifApiRouter
): GifDataSource{

    override suspend fun fetchGitPage(category: GifCategory, page: Int): GifResponse {
        return client.get(apiRouter.buildGifUrl(category, page))
    }

    override suspend fun fetchRandomGif(): GifDTO {
        return client.get(apiRouter.buildRandomGifUrl())
    }

}