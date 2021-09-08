package com.thanhnvdn.tmdbclient.data.repository.movie.datasourceImpl

import com.thanhnvdn.tmdbclient.data.api.TMDBService
import com.thanhnvdn.tmdbclient.data.model.movie.MovieList
import com.thanhnvdn.tmdbclient.data.repository.movie.datasource.MovieRemoteDatasource
import retrofit2.Response

class MovieRemoteDatasourceImpl(
    private val tmdbService: TMDBService, private val apiKey: String
    ): MovieRemoteDatasource {
    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)

}