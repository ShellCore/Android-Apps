package com.shell.android.thefm.api.topartist.response


import com.google.gson.annotations.SerializedName

data class Artists(
    val artist: List<Artist>,
    @SerializedName("@attr")
    val attr: Attr
)