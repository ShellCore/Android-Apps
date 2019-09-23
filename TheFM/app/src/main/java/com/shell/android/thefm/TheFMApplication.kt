package com.shell.android.thefm

import android.app.Application
import com.shell.android.thefm.api.LastFmApiClient
import com.shell.android.thefm.ui.topartists.di.DaggerTopArtistComponent
import com.shell.android.thefm.ui.topartists.di.TopArtistComponent
import com.shell.android.thefm.ui.topartists.di.TopArtistsModule

class TheFMApplication: Application() {

    val topArtistComponent: TopArtistComponent by lazy {
        DaggerTopArtistComponent.builder()
            .lastFmApiClient(LastFmApiClient())
            .topArtistsModule(TopArtistsModule())
            .build()
    }
}