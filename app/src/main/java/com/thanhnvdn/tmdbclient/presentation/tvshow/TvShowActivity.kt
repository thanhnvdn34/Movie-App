package com.thanhnvdn.tmdbclient.presentation.tvshow

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.thanhnvdn.tmdbclient.databinding.ActivityTvShowBinding

class TvShowActivity : AppCompatActivity() {
    private lateinit var binding: ActivityTvShowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTvShowBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}