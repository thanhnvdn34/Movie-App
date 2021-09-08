package com.thanhnvdn.tmdbclient.data.repository.movie

import android.util.Log
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieLocalDatasource
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import com.thanhnvdn.tmdbclient.domain.repository.MovieRepository

class MovieRepositoryImpl(
    private val movieRemoteDatasource: MovieRemoteDatasource,
    private val movieLocalDatasource: MovieLocalDatasource,
    private val movieCacheDataSource: MovieCacheDataSource
): MovieRepository {
    override suspend fun getMovies(): List<Movie>? {
        return getMoviesFromCache()
    }

    override suspend fun updateMovies(): List<Movie>? {
        val newListOfMovies = getMoviesFromAPI()
        movieLocalDatasource.clearALl()
        movieLocalDatasource.saveMovieToDB(newListOfMovies)
        movieCacheDataSource.saveMovieToCache(newListOfMovies)
        return newListOfMovies
    }

    private suspend fun getMoviesFromAPI(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val response = movieRemoteDatasource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }

        return movieList
    }

    private suspend fun getMoviesFromDB(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val movieList = movieLocalDatasource.getMoviesFromDB()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromAPI()
            movieLocalDatasource.saveMovieToDB(movieList)
        }

        return movieList
    }

    private suspend fun getMoviesFromCache(): List<Movie> {
        lateinit var movieList: List<Movie>

        try {
            val movieList = movieCacheDataSource.getMoviesFromCache()
        }catch (ex: Exception) {
            Log.i("TAG", ex.message.toString())
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDB()
            movieCacheDataSource.saveMovieToCache(movieList)
        }

        return movieList
    }
}