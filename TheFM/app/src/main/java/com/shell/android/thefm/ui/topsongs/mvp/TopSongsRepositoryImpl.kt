package com.shell.android.thefm.ui.topsongs.mvp

import com.shell.android.thefm.api.LastFmService
import com.shell.android.thefm.api.topsongs.response.Track
import io.reactivex.Observable

class TopSongsRepositoryImpl(
    private val service: LastFmService
) : TopSongsRepository {

    override fun getTopSongs(): Observable<Track> {
        return service.getTopSongs("chart.gettoptracks")
            .concatMap {
                Observable.fromIterable(it.tracks.track)
            }
    }
}