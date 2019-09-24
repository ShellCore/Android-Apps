package com.shell.android.thefm.ui.topsongs.mvp

import com.shell.android.thefm.api.topsongs.response.Track
import io.reactivex.Observable

interface TopSongsInteractor {
    fun result(): Observable<Track>
}