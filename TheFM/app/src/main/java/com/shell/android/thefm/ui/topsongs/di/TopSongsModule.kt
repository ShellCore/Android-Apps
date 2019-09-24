package com.shell.android.thefm.ui.topsongs.di

import com.shell.android.thefm.api.LastFmService
import com.shell.android.thefm.ui.topsongs.mvp.*
import dagger.Module
import dagger.Provides

@Module
class TopSongsModule {

    @Provides
    fun providesTopSongsPresenter(interactor: TopSongsInteractor): TopSongsPresenter =
        TopSongsPresenterImpl(interactor)

    @Provides
    fun providesTopSongsInteractor(repository: TopSongsRepository): TopSongsInteractor =
        TopSongsInteractorImpl(repository)

    @Provides
    fun providesTopSongsRepository(service: LastFmService): TopSongsRepository =
        TopSongsRepositoryImpl(service)
}