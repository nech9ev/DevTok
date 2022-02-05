package com.nech9ev.data

import com.nech9ev.core.GifCategory
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject

@ExperimentalCoroutinesApi
@HiltAndroidTest
class GifRepositoryImplTest {

    @Inject
    lateinit var repository: GifRepositoryImpl

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Before
    fun setup(){
        hiltRule.inject()
    }

    @Test
    fun getNext_ZeroPage_RealApi() = runTest {  //TODO MockWebServer
        val author = repository.getNext(GifCategory.LATEST).author
        assertEquals("xakep", author)
    }

}