package com.thanhnvdn.tmdbclient.presentation.artist

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.thanhnvdn.tmdbclient.R
import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.databinding.ActivityArtistBinding
import com.thanhnvdn.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class ArtistActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: ArtistViewModelFactory
    private lateinit var binding: ActivityArtistBinding
    private lateinit var viewModel: ArtistViewModel
    private lateinit var adapter: ArtistAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_artist)
        (application as Injector).createArtistSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[ArtistViewModel::class.java]
        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.artistRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = ArtistAdapter()
        binding.artistRecyclerView.adapter = adapter
        displayPopularArtists()
    }

    private fun displayPopularArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getArtists()
        responseData.observe(this, {
            Log.d("ArtistActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.artistProgressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        Log.d("ArtistActivity", "onCreateOptionsMenu")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                updateArtists()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateArtists() {
        binding.artistProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Artist>?> = viewModel.updateArtists()
        response.observe(this, {
            Log.d("ArtistActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.artistProgressBar.visibility = View.GONE
        })
    }
}