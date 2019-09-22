package com.shell.android.thefm.api.topartist.response


import com.google.gson.annotations.SerializedName

data class Artist(
    val image: List<Image>,
    val listeners: String,
    val mbid: String,
    val name: String,
    val playcount: String,
    val streamable: String,
    val url: String
)