package com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl

import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl: MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMovieToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}