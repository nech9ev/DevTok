package com.nech9ev.data

import com.nech9ev.data.datasource.GifDataSource
import com.nech9ev.data.model.GifResponse
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GifRepository @Inject constructor(
    private val dataSource: GifDataSource
) {

    private val cacheHotGif = MutableStateFlow<MutableMap<Int, GifResponse>>(mutableMapOf())
    private val cacheTopGif = MutableStateFlow<MutableMap<Int, GifResponse>>(mutableMapOf())
    private val cacheLatestGif = MutableStateFlow<MutableMap<Int, GifResponse>>(mutableMapOf())
}

