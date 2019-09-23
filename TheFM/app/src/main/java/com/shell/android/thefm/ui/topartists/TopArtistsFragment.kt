package com.shell.android.thefm.ui.topartists

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager

import com.shell.android.thefm.R
import com.shell.android.thefm.TheFMApplication
import com.shell.android.thefm.api.topartist.response.Artist
import com.shell.android.thefm.ui.topartists.mvp.TopArtistsPresenter
import com.shell.android.thefm.ui.topartists.mvp.TopArtistsView
import com.shell.android.thefm.utils.showMessage
import kotlinx.android.synthetic.main.fragment_top_artists.*
import javax.inject.Inject

class TopArtistsFragment : Fragment(), TopArtistsView {

    companion object {
        const val NUM_COLUMNS = 2
    }

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
        setupInjection()
        setupListAdapter()
    }

    private fun setupInjection() {
        (activity!!.application as TheFMApplication).topArtistComponent
            .inject(this)
    }

    private fun setupListAdapter() {
        topArtistsAdapter = TopArtistsAdapter(topArtists)
        recArtists.apply {
            adapter = topArtistsAdapter
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            layoutManager = GridLayoutManager(activity!!, NUM_COLUMNS)
        }
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
        presenter.loadData()
    }

    override fun onStop() {
        super.onStop()
        presenter.rxJavaUnsubscribe()
        topArtists.clear()
        topArtistsAdapter.notifyDataSetChanged()
    }

    override fun updateData(artist: Artist) {
        topArtists.add(artist)
        topArtistsAdapter.notifyItemInserted(topArtists.size - 1)
    }

    override fun showMessage(message: String) {
        topArtistContainer.showMessage(message)
    }

    override fun getContext(): Context {
        return activity!!
    }
}
