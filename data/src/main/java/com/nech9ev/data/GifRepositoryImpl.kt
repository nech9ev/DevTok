package com.nech9ev.data

import com.nech9ev.core.GifCategory
import com.nech9ev.data.cache.GifCache
import com.nech9ev.data.datasource.GifDataSource
import com.nech9ev.domain.GifRepository
import com.nech9ev.domain.model.Gif
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.random.Random

@Singleton
class GifRepositoryImpl @Inject constructor(
    private val dataSourceImpl: GifDataSource
): GifRepository {

    private var hotGifCache: GifCache = GifCache(Random.nextInt(0, 1000))
    private var topGifCache: GifCache = GifCache(Random.nextInt(0, 1000))
    private var latestGifCache: GifCache = GifCache(Random.nextInt(0, 1000))

    override suspend fun getNext(category: GifCategory): Gif {
        val cache = getCache(category)
        return if (cache.hasNext()) {
            cache.getNext()
        }else{
            cache.load(cache.currentPage() + 1 ,
                dataSourceImpl.fetchGitPage(category, cache.currentPage() + 1).map()
            )
            cache.getNext()
        }
    }

    override suspend fun getPrev(category: GifCategory): Gif {
        val cache = getCache(category)
        return if (cache.hasPrev()) {
            cache.getPrev()
        }else{
            cache.load(cache.currentPage() - 1,
                dataSourceImpl.fetchGitPage(category, cache.currentPage() - 1).map()
            )
            cache.getPrev()
        }
    }

    private fun getCache(category: GifCategory): GifCache {
        return when(category){
            GifCategory.HOT -> hotGifCache
            GifCategory.TOP -> topGifCache
            GifCategory.LATEST -> latestGifCache
        }
    }

}

