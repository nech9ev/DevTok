package com.nech9ev.domain

import com.nech9ev.core.GifCategory
import com.nech9ev.domain.model.Gif

interface GifRepository {

    suspend fun getNext(category: GifCategory): Gif

    suspend fun getPrev(category: GifCategory): Gif

}