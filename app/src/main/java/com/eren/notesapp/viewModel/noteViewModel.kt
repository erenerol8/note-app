package com.eren.notesapp.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.eren.notesapp.data.noteDatabase
import com.eren.notesapp.model.Notes
import com.eren.notesapp.repository.noteRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class noteViewModel(application: Application) : AndroidViewModel(application) {


    private val repo: noteRepo
    private val allNote: LiveData<List<Notes>>

    init {
        val dao = noteDatabase.getDatabase(application).noteDao()
        repo = noteRepo(dao)
        allNote = repo.allNote
    }

    fun insert(notes: Notes) = viewModelScope.launch(Dispatchers.IO){
        repo.insert(notes)
        }
    }