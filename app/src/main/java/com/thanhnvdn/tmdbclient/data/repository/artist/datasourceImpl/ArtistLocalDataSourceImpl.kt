package com.thanhnvdn.tmdbclient.data.repository.artist.datasourceImpl

import com.thanhnvdn.tmdbclient.data.db.ArtistDao
import com.thanhnvdn.tmdbclient.data.model.artist.Artist
import com.thanhnvdn.tmdbclient.data.repository.artist.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImpl(private val artistDao: ArtistDao): ArtistLocalDataSource {
    override suspend fun getArtistsFromDB(): List<Artist> = artistDao.getArtists()

    override suspend fun saveArtistsToDB(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearALl() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }
    }
}