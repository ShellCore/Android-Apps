package com.shell.android.thefm.api

import com.shell.android.thefm.api.topartist.response.TopArtistResponse
import com.shell.android.thefm.api.topsongs.response.TopSongResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFmService {

    @GET(".")
    fun getTopArtist(@Query("method") method: String): Observable<TopArtistResponse>

    @GET(".")
    fun getTopSongs(@Query("method") method: String): Observable<TopSongResponse>

}
