package com.thanhnvdn.tmdbclient.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.thanhnvdn.tmdbclient.data.db.ArtistDao
import com.thanhnvdn.tmdbclient.data.db.MovieDao
import com.thanhnvdn.tmdbclient.data.db.TMDBDatabase
import com.thanhnvdn.tmdbclient.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun providesDatabase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(context, TMDBDatabase::class.java, "tmdbclient")
            .build()
    }

    @Singleton
    @Provides
    fun providesMovieDao(tmdbDatabase: TMDBDatabase): MovieDao {
        return tmdbDatabase.movieDao()
    }

    @Singleton
    @Provides
    fun providesArtistDao(tmdbDatabase: TMDBDatabase): ArtistDao {
        return tmdbDatabase.artistDao()
    }

    @Singleton
    @Provides
    fun providesTvShowDao(tmdbDatabase: TMDBDatabase): TvShowDao {
        return tmdbDatabase.tvShowDao()
    }
}