package com.shell.android.thefm.ui.topartists.di

import com.shell.android.thefm.api.LastFmApiClient
import com.shell.android.thefm.ui.topartists.TopArtistsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [TopArtistsModule::class, LastFmApiClient::class])
interface TopArtistComponent {

    fun inject(view: TopArtistsFragment)
}