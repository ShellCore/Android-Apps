package com.shell.android.thefm.ui.topartists.mvp

import android.content.Context
import com.shell.android.thefm.api.topartist.response.Artist

interface TopArtistsView {
    fun updateData(artist: Artist)
    fun showMessage(message: String)
    fun getContext(): Context
}