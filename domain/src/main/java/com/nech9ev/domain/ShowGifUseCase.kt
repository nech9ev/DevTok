package com.nech9ev.domain

import com.nech9ev.core.GifCategory
import com.nech9ev.domain.model.Gif
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ShowGifUseCase @Inject constructor(
    private val repository: GifRepository
){

    suspend fun getNext(category: GifCategory): Gif {
        return repository.getNext(category)
    }

    /**
     * if not recycler...
     */
    suspend fun getPrev(category: GifCategory): Gif {
        return repository.getPrev(category)
    }

}