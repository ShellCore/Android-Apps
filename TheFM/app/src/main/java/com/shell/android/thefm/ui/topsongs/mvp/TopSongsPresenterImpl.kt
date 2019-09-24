package com.shell.android.thefm.ui.topsongs.mvp

import android.util.Log
import com.shell.android.thefm.R
import com.shell.android.thefm.api.topsongs.response.Track
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers

class TopSongsPresenterImpl(
    private val interactor: TopSongsInteractor
) : TopSongsPresenter {

    companion object {
        const val TAG = "TopSongsPresenterImpl"
    }

    private var view: TopSongsView? = null
    private var subscription: Disposable? = null

    override fun loadData() {
        subscription = interactor.result()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object: DisposableObserver<Track>() {
                override fun onComplete() {
                    view?.showMessage(view?.getContext()!!.getString(R.string.service_message_getTopSongs_success))
                }

                override fun onNext(track: Track) {
                    view?.updateData(track)
                }

                override fun onError(e: Throwable) {
                    Log.e(TAG, e.localizedMessage)
                    view?.showMessage(view?.getContext()!!.getString(R.string.service_message_getTopSongs_error))
                }
            })
    }

    override fun rxJavaUnsubscribe() {
        if (subscription != null && subscription!!.isDisposed)
            subscription!!.dispose()
    }

    override fun setView(view: TopSongsView) {
        this.view = view
    }
}