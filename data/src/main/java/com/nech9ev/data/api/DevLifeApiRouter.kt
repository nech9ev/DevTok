package com.nech9ev.data.api

import com.nech9ev.core.GifCategory

class DevLifeApiRouter: GifApiRouter {
    private val baseUrl = "https://developerslife.ru"
    private val jsonQuery = "?json=true"

    override fun buildGifUrl(category: GifCategory, page: Int): String {
        return "$baseUrl/${category.getValue()}/$page$jsonQuery"
    }

    override fun buildRandomGifUrl(): String {
        return "$baseUrl/random$jsonQuery"
    }
}