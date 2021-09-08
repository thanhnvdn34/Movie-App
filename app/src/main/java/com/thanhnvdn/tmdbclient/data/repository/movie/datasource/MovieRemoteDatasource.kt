package com.thanhnvdn.tmdbclient.data.repository.movie.datasource

import com.thanhnvdn.tmdbclient.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDatasource {
    suspend fun getMovies(): Response<MovieList>
}