package com.example.android.marvelicious.data.source

import androidx.lifecycle.LiveData
import com.example.android.marvelicious.data.source.database.LocalDataSource
import com.example.android.marvelicious.data.source.network.RemoteDataSource
import com.example.android.marvelicious.domain.Models
import timber.log.Timber

class Repository(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) {
    suspend fun getCharacters(): List<Models.Character> {
        try {
            updateCharactersFromRemoteDataSource()
        } catch (ex: Exception) {
            Timber.e(ex)
        }
        return localDataSource.getCharacters()
    }

    fun observeCharacters(): LiveData<List<Models.Character>> {
        return localDataSource.observeCharacters()
    }

    suspend fun refreshCharacters() {
        updateCharactersFromRemoteDataSource()
    }

    private suspend fun updateCharactersFromRemoteDataSource() {
        val remoteTasks = remoteDataSource.getCharacters()
        localDataSource.saveCharacters(remoteTasks)
    }
}