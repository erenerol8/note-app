package com.eren.notesapp.repository

import androidx.lifecycle.LiveData
import com.eren.notesapp.data.noteDao
import com.eren.notesapp.model.Notes

class noteRepo(private val noteDao: noteDao){
  val allNote : LiveData<List<Notes>> = noteDao.getAllNots()

    suspend fun insert(notes : Notes){
        noteDao.insert(notes)
    }
}