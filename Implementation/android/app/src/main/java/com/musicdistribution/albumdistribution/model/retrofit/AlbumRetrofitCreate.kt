package com.musicdistribution.albumdistribution.model.retrofit

import com.musicdistribution.albumdistribution.data.domain.Genre

data class AlbumRetrofitCreate(
    val albumName: String,
    val totalLength: Int,
    val isPublished: Boolean,
    val genre: Genre,
    val artistName: String,
    val producerName: String,
    val composerName: String,
    val creatorId: String
)