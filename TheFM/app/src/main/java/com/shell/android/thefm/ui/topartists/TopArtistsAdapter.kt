package com.shell.android.thefm.ui.topartists

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.shell.android.thefm.R
import com.shell.android.thefm.api.topartist.response.Artist
import com.shell.android.thefm.api.topartist.response.Image
import com.shell.android.thefm.utils.setImage

class TopArtistsAdapter(var artists: ArrayList<Artist>): RecyclerView.Adapter<TopArtistsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_artist, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(artists[position])
    }

    override fun getItemCount(): Int {
        return artists.size
    }

    class ViewHolder(itemview: View): RecyclerView.ViewHolder(itemview) {

        // Components
        private lateinit var txtArtistName: TextView
        private lateinit var txtCounter: TextView

        private lateinit var artist: Artist

        fun bind(artist: Artist) {
            this.artist = artist
            initializeComponents()
            addArtistInfo()
        }

        private fun addArtistInfo() {
            txtArtistName.text = artist.name
            txtCounter.text = artist.playcount
        }

        private fun initializeComponents() {
            txtArtistName = itemView.findViewById(R.id.txtArtistName)
            txtCounter = itemView.findViewById(R.id.txtCounter)
        }
    }
}