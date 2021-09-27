package com.thanhnvdn.tmdbclient.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.domain.usecase.GetMoviesUseCase
import com.thanhnvdn.tmdbclient.domain.usecase.UpdateMoviesUseCase
import com.thanhnvdn.tmdbclient.getOrAwaitValue
import com.thanhnvdn.tmdbclient.repository.movie.FakeMovieRepository
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MovieViewModel

    @Before
    fun setUp() {
        val fakeMovieRepository = FakeMovieRepository()
        val getMoviesUsecase = GetMoviesUseCase(fakeMovieRepository)
        val updateMoviesUsecase = UpdateMoviesUseCase(fakeMovieRepository)
        viewModel = MovieViewModel(getMoviesUsecase,updateMoviesUsecase)
    }

    @Test
    fun getMovies_returnsCurrentList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))

        val currentList = viewModel.getMovies().getOrAwaitValue()
        Truth.assertThat(currentList).isEqualTo(movies)

    }

    @Test
    fun updateMovies_returnsUpdatedList(){
        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))

        val updatedList = viewModel.updateMovies().getOrAwaitValue()
        Truth.assertThat(updatedList).isEqualTo(movies)

    }
}