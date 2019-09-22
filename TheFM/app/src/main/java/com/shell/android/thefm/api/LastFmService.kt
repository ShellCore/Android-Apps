package com.shell.android.thefm.api

import com.shell.android.thefm.api.topartist.response.TopArtistResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmService {

    @GET(".")
    fun getTopArtist(@Query("method") method: String): TopArtistResponse

}
