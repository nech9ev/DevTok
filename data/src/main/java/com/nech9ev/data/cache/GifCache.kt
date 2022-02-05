package com.nech9ev.data.cache

import com.nech9ev.domain.model.Gif

class GifCache(
    private var currentPage: Int = -1,
    private var currentIndex: Int = -1,
    private val gifs: MutableMap<Int, List<Gif>> = mutableMapOf()
) {
    fun hasNext(): Boolean{
        return gifs[currentPage]?.lastIndex ?: -1 >= (currentIndex + 1) || gifs.containsKey(currentPage + 1)
    }

    fun hasPrev(): Boolean{
        return currentIndex > 0 || gifs.containsKey(currentPage - 1)
    }

    fun getNext(): Gif{
        return if(gifs[currentPage]?.lastIndex?: -1 >= (currentIndex + 1)){
            gifs[currentPage]!![++currentIndex]
        }else{
            currentIndex = 0
            gifs[++currentPage]!![currentIndex]
        }
    }

    fun getPrev(): Gif{
        return if(currentIndex > 0){
            gifs[currentPage]!![--currentIndex]
        }else{
            currentIndex = 0
            gifs[--currentPage]!![currentIndex]
        }
    }

    fun load(page: Int, gifPage: List<Gif>){
        gifs[page] = gifPage
    }

    fun currentPage() = currentPage

}