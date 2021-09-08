package com.thanhnvdn.tmdbclient.data.repository.movie.datasource

import com.thanhnvdn.tmdbclient.data.model.movie.Movie

interface MovieLocalDatasource {

    suspend fun getMoviesFromDB(): List<Movie>
    suspend fun saveMovieToDB(movies: List<Movie>)
    suspend fun clearALl()
}