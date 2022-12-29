package com.nedushny.spotifyclone.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.nedushny.spotifyclone.data.entities.Song
import com.nedushny.spotifyclone.other.Constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

/**
 * Created by nedushny on 29.12.2022
 */
class MusicDatabase {

    private val firestore = FirebaseFirestore.getInstance()
    private val songCollection = firestore.collection(SONG_COLLECTION)

    suspend fun getAllSongs(): List<Song> {
        return try {
            songCollection.get().await().toObjects(Song::class.java)
        } catch (e: Exception) {
            emptyList()
        }
    }
}