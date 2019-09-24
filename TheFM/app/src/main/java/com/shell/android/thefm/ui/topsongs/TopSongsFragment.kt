package com.shell.android.thefm.ui.topsongs


import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.shell.android.thefm.R
import com.shell.android.thefm.TheFMApplication
import com.shell.android.thefm.api.topsongs.response.Track
import com.shell.android.thefm.ui.topsongs.mvp.TopSongsPresenter
import com.shell.android.thefm.ui.topsongs.mvp.TopSongsView
import com.shell.android.thefm.utils.showMessage
import kotlinx.android.synthetic.main.fragment_top_songs.*
import javax.inject.Inject

class TopSongsFragment : Fragment(), TopSongsView {

    @Inject
    lateinit var presenter: TopSongsPresenter

    private lateinit var topSongsAdapter: TopSongsAdapter
    private var topSongs: ArrayList<Track> = ArrayList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_top_songs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupInjection()
        setupListAdapter()
    }

    private fun setupInjection() {
        (activity!!.application as TheFMApplication).topSongsComponent
            .inject(this)
    }

    private fun setupListAdapter() {
        topSongsAdapter = TopSongsAdapter(topSongs)
        recSongs.apply {
            adapter = topSongsAdapter
            itemAnimator = DefaultItemAnimator()
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(activity!!)
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
        topSongs.clear()
        topSongsAdapter.notifyDataSetChanged()
    }

    override fun updateData(track: Track) {
        topSongs.add(track)
        topSongsAdapter.notifyItemInserted(topSongs.size - 1)
    }

    override fun showMessage(message: String) {
        topSongsContainer.showMessage(message)
    }

    override fun getContext(): Context {
        return activity!!
    }
}
