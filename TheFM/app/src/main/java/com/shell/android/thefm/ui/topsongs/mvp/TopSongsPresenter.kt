package com.shell.android.thefm.ui.topsongs.mvp

interface TopSongsPresenter {
    fun loadData()
    fun rxJavaUnsubscribe()
    fun setView(view: TopSongsView)
}