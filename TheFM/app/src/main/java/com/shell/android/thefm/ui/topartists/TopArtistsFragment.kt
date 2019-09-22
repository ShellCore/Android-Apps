package com.shell.android.thefm.ui.topartists

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.shell.android.thefm.R
import com.shell.android.thefm.TheFMApplication
import com.shell.android.thefm.api.topartist.response.Artist
import com.shell.android.thefm.ui.topartists.mvp.TopArtistsPresenter
import com.shell.android.thefm.ui.topartists.mvp.TopArtistsView
import javax.inject.Inject

class TopArtistsFragment : Fragment(), TopArtistsView {

    @Inject
    lateinit var presenter: TopArtistsPresenter

    private lateinit var topArtistsAdapter: TopArtistsAdapter
    private var topArtists: ArrayList<Artist> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_artists, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun updateData(artist: Artist) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showMessage(message: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
