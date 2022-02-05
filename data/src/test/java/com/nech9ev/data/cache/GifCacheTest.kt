package com.nech9ev.data.cache

import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Test

class GifCacheTest {

    lateinit var cache: GifCache

    @Before
    fun setup(){
        cache = GifCache()
    }

    @Test
    fun nothingLoaded_hasNext_false() {
        assertThat(cache.hasNext()).isFalse()
    }
}