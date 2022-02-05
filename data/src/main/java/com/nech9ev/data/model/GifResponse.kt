package com.nech9ev.data.model

import kotlinx.serialization.Serializable

@Serializable
data class GifResponse(
	val result: List<GifDTO>,
	val totalCount: Int
)

