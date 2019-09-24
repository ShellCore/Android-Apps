package com.shell.android.thefm.ui.topsongs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shell.android.thefm.R
import com.shell.android.thefm.api.topsongs.response.Track

class TopSongsAdapter(var tracks: ArrayList<Track>): RecyclerView.Adapter<TopSongsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_song, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(tracks[position])
    }

    override fun getItemCount(): Int {
        return tracks.size
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        // Components
        private lateinit var txtSong: TextView
        private lateinit var txtArtist: TextView

        private lateinit var track: Track

        fun bind(track: Track) {
            this.track = track
            initializeComponents()
            addSongInfo(track)
        }

        private fun addSongInfo(track: Track) {
            txtSong.text = track.name
            txtArtist.text = track.artist.name
        }

        private fun initializeComponents() {
            txtSong = itemView.findViewById(R.id.txtSong)
            txtArtist = itemView.findViewById(R.id.txtArtist)
        }
    }
}