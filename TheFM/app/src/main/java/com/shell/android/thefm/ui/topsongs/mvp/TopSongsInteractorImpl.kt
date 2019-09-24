package com.shell.android.thefm.ui.topsongs.mvp

import com.shell.android.thefm.api.topsongs.response.Track
import io.reactivex.Observable

class TopSongsInteractorImpl(
    private val repository: TopSongsRepository
) : TopSongsInteractor {

    override fun result(): Observable<Track> {
        return repository.getTopSongs()
    }
}