package com.shell.android.thefm.ui.topartists.mvp

import com.shell.android.thefm.api.LastFmService
import com.shell.android.thefm.api.topartist.response.Artist
import io.reactivex.Observable

class TopArtistsRepositoryImpl(
    private val service: LastFmService
) : TopArtistsRepository {

    override fun getTopArtist(): Observable<Artist> {
        return service.getTopArtist("chart.gettopartists")
            .concatMap {
                Observable.fromIterable(it.artists.artist)
            }
    }
}