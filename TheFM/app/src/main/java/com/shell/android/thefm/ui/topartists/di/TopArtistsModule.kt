package com.shell.android.thefm.ui.topartists.di

import com.shell.android.thefm.api.LastFmService
import com.shell.android.thefm.ui.topartists.mvp.*
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class TopArtistsModule {

    @Provides
    fun providesTopArtistsPresenter(interactor: TopArtistsInteractor): TopArtistsPresenter =
        TopArtistsPresenterImpl(interactor)

    @Provides
    fun providesTopArtistsInteractor(repository: TopArtistsRepository): TopArtistsInteractor =
        TopArtistsInteractorImpl(repository)

    @Provides
    @Singleton
    fun providesTopArtistsRepository(service: LastFmService): TopArtistsRepository =
        TopArtistsRepositoryImpl(service)
}