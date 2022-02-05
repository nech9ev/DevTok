package com.nech9ev.domain

interface GifRepository {

    suspend fun getHot()

    suspend fun getTop()

    suspend fun getLatest()

    suspend fun getRandom()

}