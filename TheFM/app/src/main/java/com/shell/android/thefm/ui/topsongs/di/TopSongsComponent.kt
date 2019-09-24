package com.shell.android.thefm.ui.topsongs.di

import com.shell.android.thefm.api.LastFmApiClient
import com.shell.android.thefm.ui.topsongs.TopSongsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TopSongsModule::class, LastFmApiClient::class])
interface TopSongsComponent {

    fun inject(tarjet: TopSongsFragment)
}