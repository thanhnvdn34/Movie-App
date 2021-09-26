package com.thanhnvdn.tmdbclient.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.data.model.movie.Movie
import com.thanhnvdn.tmdbclient.data.model.tvshow.TvShow

@Database(entities = [Movie::class, TvShow::class, Artist::class], version = 2, exportSchema = true)
abstract class  TMDBDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun tvShowDao(): TvShowDao

    abstract fun artistDao(): ArtistDao
}