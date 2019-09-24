package com.shell.android.thefm.api.topsongs.response


import com.google.gson.annotations.SerializedName

data class Streamable(
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)