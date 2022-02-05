package com.nech9ev.data.model

import com.nech9ev.domain.model.Gif
import kotlinx.serialization.Serializable

@Serializable
data class GifDTO(
    val date: String,
    val previewURL: String,
    val author: String,
    val description: String,
    val type: String,
    val videoSize: Int,
    val gifURL: String,
    val videoPath: String,
    val videoURL: String,
    val fileSize: Int,
    val gifSize: Int,
    val commentsCount: Int,
    val width: String,
    val votes: Int,
    val id: Int,
    val height: String,
    val canVote: Boolean
){
    fun map() = Gif(
        description = this.description,
        votes = this.votes,
        author = this.author,
        gifUrl = this.gifURL,
        previewUrl = this.previewURL
    )
}
