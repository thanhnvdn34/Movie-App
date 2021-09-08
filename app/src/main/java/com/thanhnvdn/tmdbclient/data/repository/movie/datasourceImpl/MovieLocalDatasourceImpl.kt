package com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl

import com.thanhnvdn.tmdbclient.data.db.MovieDao
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDatasourceImpl(private val movieDao: MovieDao): MovieLocalDatasource {
    override suspend fun getMoviesFromDB(): List<Movie> = movieDao.getMovies()

    override suspend fun saveMovieToDB(movies: List<Movie>) {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.saveMovies(movies)
        }
    }

    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}