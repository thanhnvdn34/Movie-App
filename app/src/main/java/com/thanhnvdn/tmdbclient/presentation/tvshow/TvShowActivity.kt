package com.thanhnvdn.tmdbclient.presentation.tvshow

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
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow
import com.thanhnvdn.tmdbclient.databinding.ActivityTvShowBinding
import com.thanhnvdn.tmdbclient.presentation.di.Injector
import javax.inject.Inject

class TvShowActivity : AppCompatActivity() {
    @Inject
    lateinit var factory: TvShowViewModelFactory
    private lateinit var binding: ActivityTvShowBinding
    private lateinit var viewModel: TvShowViewModel
    private lateinit var adapter: TvShowAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_tv_show)
        (application as Injector).createTvShowSubComponent()
            .inject(this)

        viewModel = ViewModelProvider(this, factory)[TvShowViewModel::class.java]
        initRecyclerView()

    }


    private fun initRecyclerView() {
        binding.tvShowRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = TvShowAdapter()
        binding.tvShowRecyclerView.adapter = adapter
        displayPopularTvShows()
    }

    private fun displayPopularTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val responseData = viewModel.getTvShows()
        responseData.observe(this, {
            Log.d("TvShowActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            } else {
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
            binding.tvShowProgressBar.visibility = View.GONE
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.update, menu)
        Log.d("TvShowActivity", "onCreateOptionsMenu")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.action_update -> {
                updateTvShows()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun updateTvShows() {
        binding.tvShowProgressBar.visibility = View.VISIBLE
        val response: LiveData<List<TvShow>?> = viewModel.updateTvShows()
        response.observe(this, {
            Log.d("TvShowActivity", it.toString())
            if (it != null) {
                adapter.setList(it)
                adapter.notifyDataSetChanged()
            }
            binding.tvShowProgressBar.visibility = View.GONE
        })
    }
}