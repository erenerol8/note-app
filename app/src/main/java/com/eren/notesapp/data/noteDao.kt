package com.eren.notesapp.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.eren.notesapp.model.Notes

@Dao
interface noteDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(note: Notes)

    @Query("Select * FROM note_table ORDER BY id DESC")
    fun getAllNots() : LiveData<List<Notes>>

}