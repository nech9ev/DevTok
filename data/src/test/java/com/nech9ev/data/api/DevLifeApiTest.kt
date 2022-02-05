package com.nech9ev.data.api

import com.nech9ev.core.GifCategory
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class DevLifeApiTest {

    lateinit var apiRouter: GifApiRouter

    @Before
    fun setUp() {
        apiRouter = DevLifeApiRouter()
    }

    @Test
    fun buildHotGifUrl() {
        assertEquals(
            apiRouter.buildGifUrl(GifCategory.HOT, TestApiConstants.page),
            TestApiConstants.devLifeHotUrl
        )
    }

    @Test
    fun buildLatestGifUrl() {
        assertEquals(
            apiRouter.buildGifUrl(GifCategory.LATEST, TestApiConstants.page),
            TestApiConstants.devLifeLatestUrl
        )
    }

    @Test
    fun buildTopGifUrl() {
        assertEquals(
            apiRouter.buildGifUrl(GifCategory.TOP, TestApiConstants.page),
            TestApiConstants.devLifeTopUrl
        )
    }

    @Test
    fun buildRandomGifUrl() {
        assertEquals(
            apiRouter.buildRandomGifUrl(),
            TestApiConstants.devLifeRandomUrl
        )
    }

}