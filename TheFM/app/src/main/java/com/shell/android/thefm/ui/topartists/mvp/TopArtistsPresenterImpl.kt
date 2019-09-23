package com.shell.android.thefm.ui.topartists.mvp

import android.util.Log
import com.shell.android.thefm.R
import com.shell.android.thefm.api.topartist.response.Artist
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class TopArtistsPresenterImpl(
    private val interactor: TopArtistsInteractor
) : TopArtistsPresenter {

    companion object {
        const val TAG = "PresenterImpl"
    }

    private var view: TopArtistsView? = null
    private var subscription: Disposable? = null

    override fun loadData() {
        subscription = interactor.result()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableObserver<Artist>() {
                override fun onComplete() {
                    view?.showMessage(view?.getContext()!!.getString(R.string.service_message_getTopArtists_success))
                }

                override fun onNext(artist: Artist) {
                    view?.updateData(artist)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, e.localizedMessage)
                    view?.showMessage(view?.getContext()!!.getString(R.string.service_message_getTopArtists_error))
                }

            })
    }

    override fun rxJavaUnsubscribe() {
        if (subscription != null && subscription!!.isDisposed) {
            subscription!!.dispose()
        }
    }

    override fun setView(view: TopArtistsView) {
        this.view = view
    }
}