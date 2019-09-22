package com.shell.android.thefm.api.topartist.response


import com.google.gson.annotations.SerializedName

data class Attr(
    val page: String,
    val perPage: String,
    val total: String,
    val totalPages: String
)