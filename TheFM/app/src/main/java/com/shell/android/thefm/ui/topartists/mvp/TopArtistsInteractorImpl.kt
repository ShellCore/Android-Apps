package com.shell.android.thefm.ui.topartists.mvp

import com.shell.android.thefm.api.topartist.response.Artist
import io.reactivex.Observable

class TopArtistsInteractorImpl(
    private val repository: TopArtistsRepository
) : TopArtistsInteractor {

    override fun result(): Observable<Artist> {
        return repository.getTopArtist()
    }
}