package com.thanhnvdn.tmdbclient.domain.repository

import com.thanhnvdn.tmdbclient.data.model.movie.Movie

interface MovieRepository {

    suspend fun getMovies(): List<Movie>?

    suspend fun updateMovies(): List<Movie>?
}