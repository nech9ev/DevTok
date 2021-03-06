package com.nech9ev.data.api

import com.nech9ev.core.GifCategory

interface GifApiRouter {

    fun buildGifUrl(category: GifCategory, page: Int): String

    fun buildRandomGifUrl(): String
}