package com.nech9ev.data

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
            apiRouter.buildGifUrl(GifCategory.HOT, TestConstants.page),
            TestConstants.devLifeHotUrl
        )
    }

    @Test
    fun buildLatestGifUrl() {
        assertEquals(
            apiRouter.buildGifUrl(GifCategory.LATEST, TestConstants.page),
            TestConstants.devLifeLatestUrl
        )
    }

    @Test
    fun buildTopGifUrl() {
        assertEquals(
            apiRouter.buildGifUrl(GifCategory.TOP, TestConstants.page),
            TestConstants.devLifeTopUrl
        )
    }

    @Test
    fun buildRandomGifUrl() {
        assertEquals(
            apiRouter.buildRandomGifUrl(),
            TestConstants.devLifeRandomUrl
        )
    }

}