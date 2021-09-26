package com.thanhnvdn.tmdbclient.presentation.artist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhnvdn.tmdbclient.R
import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.databinding.ListItemBinding
import java.util.*

class ArtistAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val artistList = ArrayList<Artist>()

    fun setList(artists: List<Artist>) {
        artistList.clear()
        artistList.addAll(artists)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(artistList[position])
    }

    override fun getItemCount(): Int {
        return artistList.size
    }

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(artist: Artist) {
            binding.titleTextView.text = artist.name
            binding.descriptionTextView.text = artist.popularity.toString()
            val posterUrl: String = "https://image.tmdb.org/t/p/w500" +artist.profilePath
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)
        }
}