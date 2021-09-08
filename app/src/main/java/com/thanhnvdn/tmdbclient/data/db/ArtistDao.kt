package com.thanhnvdn.tmdbclient.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.thanhnvdn.tmdbclient.data.model.artist.Artist

@Dao
interface ArtistDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(movies: List<Artist>)

    @Query("delete from popular_artists ")
    suspend fun deleteAllArtists()

    @Query("select * from popular_artists")
    suspend fun getArtists(): List<Artist>
}