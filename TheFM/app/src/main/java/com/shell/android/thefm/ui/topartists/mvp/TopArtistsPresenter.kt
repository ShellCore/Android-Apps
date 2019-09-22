package com.shell.android.thefm.ui.topartists.mvp

interface TopArtistsPresenter {
    fun loadData()
    fun rxJavaUnsubscribe()
    fun setView(view: TopArtistsView)
}