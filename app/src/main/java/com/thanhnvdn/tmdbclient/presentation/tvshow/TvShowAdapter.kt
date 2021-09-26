package com.thanhnvdn.tmdbclient.presentation.tvshow

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.thanhnvdn.tmdbclient.R
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.databinding.ListItemBinding
import java.util.*

class TvShowAdapter(): RecyclerView.Adapter<MyViewHolder>() {
    private val tvShowList = ArrayList<TvShow>()

    fun setList(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList.addAll(tvShows)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater: LayoutInflater = LayoutInflater.from(parent.context)
        val binding: ListItemBinding = DataBindingUtil.inflate(layoutInflater, R.layout.list_item, parent, false)
        return MyViewHolder(binding = binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(tvShowList[position])
    }

    override fun getItemCount(): Int {
        return tvShowList.size
    }

}

class MyViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root) {

        fun bind(tvShow: TvShow) {
            binding.titleTextView.text = tvShow.name
            binding.descriptionTextView.text = tvShow.overview
            val posterUrl: String = "https://image.tmdb.org/t/p/w500" +tvShow.posterPath
            Glide.with(binding.imageView.context)
                .load(posterUrl)
                .into(binding.imageView)
        }
}