package com.thanhnvdn.tmdbclient.presentation.movie

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhnvdn.tmdbclient.R
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.databinding.ListItemBinding
import java.util.*

class MovieAdapter : RecyclerView.Adapter<MyViewHolder>() {
    private val movieList = ArrayList<Movie>()

    fun setList(movies: List<Movie>) {
        movieList.clear()
        movieList.addAll(movies)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(movieList[position])
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie) {
            binding.titleTextView.text = movie.title
            binding.descriptionTextView.text = movie.overview
            val posterUrl: String = "https://image.tmdb.org/t/p/w500" +movie.posterPath
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)
        }
}