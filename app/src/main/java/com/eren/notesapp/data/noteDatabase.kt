package com.eren.notesapp.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.eren.notesapp.model.Notes

@Database(entities = [Notes::class], version = 1, exportSchema = false)
abstract class noteDatabase : RoomDatabase() {
    abstract fun noteDao(): noteDao

    companion object {
        @Volatile
        private var INSTANCE: noteDatabase? = null
        fun getDatabase(context: Context): noteDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    noteDatabase::class.java,
                    "note_database"
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                return instance

            }
        }
    }
}