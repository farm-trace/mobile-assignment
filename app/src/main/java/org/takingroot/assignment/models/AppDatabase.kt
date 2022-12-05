package org.takingroot.assignment.models

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import org.takingroot.assignment.utils.converters.GSONConverter

@Database(entities = [Survey::class], version = 1, exportSchema = false)
@TypeConverters(GSONConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun surveyDao(): SurveyDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "db"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }
}