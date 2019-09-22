package com.shell.android.thefm.api.topartist.response


import com.google.gson.annotations.SerializedName

data class Image(
    val size: String,
    @SerializedName("#text")
    val text: String
) {
    enum class Size(val value: String) {
        SMALL("small"),
        MEDIUM("medium"),
        LARGE("large"),
        EXTRALARGE("extralarge"),
        MEGA("mega")
    }
}