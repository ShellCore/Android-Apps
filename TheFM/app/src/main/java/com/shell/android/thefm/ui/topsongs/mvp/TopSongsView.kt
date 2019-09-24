package com.shell.android.thefm.ui.topsongs.mvp

import android.content.Context
import com.shell.android.thefm.api.topsongs.response.Track

interface TopSongsView {
    fun updateData(track: Track)
    fun showMessage(message: String)
    fun getContext(): Context
}