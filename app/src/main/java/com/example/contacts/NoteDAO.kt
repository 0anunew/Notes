package com.example.contacts

import androidx.lifecycle.LiveData
import androidx.room.*

interface NoteDAO{
    @Insert
    suspend fun insert(note: Note)
    @Update
    suspend fun update(note: Note)
    @Delete
    suspend fun delete(note: Note)

    @Query("SELECT * FROM note_table ORDER BY priority ASC")
    fun getAllNotes(): LiveData<MutableList<Note>>

    @Query("DELETE FROM note_table")
    fun deleteAllNotes()

    @Query("SELECT * FROM note_table WHERE noteTableID = :id")
    fun getNote(id: Int): Note
}