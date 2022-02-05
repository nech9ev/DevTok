package com.nech9ev.domain.model

data class Gif(
    val description: String,
    val votes: Int,
    val author: String,
    val gifUrl: String,
    val previewUrl: String
)