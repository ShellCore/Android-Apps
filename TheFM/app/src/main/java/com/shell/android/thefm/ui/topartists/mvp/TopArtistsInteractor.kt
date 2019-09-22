package com.shell.android.thefm.ui.topartists.mvp

import com.shell.android.thefm.api.topartist.response.Artist
import io.reactivex.Observable

interface TopArtistsInteractor {
    fun result(): Observable<Artist>
}