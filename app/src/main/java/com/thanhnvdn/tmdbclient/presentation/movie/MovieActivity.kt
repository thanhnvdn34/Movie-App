package com.thanhnvdn.tmdbclient.presentation.movie

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
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.databinding.ActivityMovieBinding
import com.thanhnvdn.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class MovieActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    private lateinit var binding: ActivityMovieBinding
    private lateinit var viewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_movie)
        (application as Injector).createMovieSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[MovieViewModel::class.java]

        initRecyclerView()
    }

    private fun initRecyclerView() {
        binding.movieRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MovieAdapter()
        binding.movieRecyclerView.adapter = adapter
        displayPopularMovies()
    }

    private fun displayPopularMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getMovies()
        responseData.observe(this, {
            Log.d("MovieActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.movieProgressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        Log.d("MovieActivity", "onCreateOptionsMenu")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                updateMovies()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateMovies() {
        binding.movieProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<Movie>?> = viewModel.updateMovies()
        response.observe(this, {
            Log.d("MovieActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.movieProgressBar.visibility = View.GONE
        })
    }
}