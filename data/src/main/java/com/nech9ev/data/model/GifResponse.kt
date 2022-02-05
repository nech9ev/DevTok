package com.nech9ev.data.model

import com.nech9ev.domain.model.Gif
import kotlinx.serialization.Serializable

@Serializable
data class GifResponse(
	val result: List<GifDTO>,
	val totalCount: Int
) {

	fun map(): List<Gif> {
		return result.map {
			it.map()
		}
	}

}