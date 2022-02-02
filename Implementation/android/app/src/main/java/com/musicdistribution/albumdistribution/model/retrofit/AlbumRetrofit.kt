package com.musicdistribution.albumdistribution.model.retrofit

import com.musicdistribution.albumdistribution.data.domain.Genre

data class AlbumRetrofit(
    val id: String,
    val albumName: String,
    val lengthInSeconds: Int,
    val isPublished: Boolean,
    val genre: Genre,
    val artistId: String,
    val artistName: String
)