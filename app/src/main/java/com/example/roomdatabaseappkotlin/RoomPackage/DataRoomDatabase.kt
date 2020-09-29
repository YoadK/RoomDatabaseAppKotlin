package com.example.roomdatabaseappkotlin.RoomPackage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [DataModelRoom::class], version = 1, exportSchema = false)
abstract class DataRoomDatabase : RoomDatabase() {

    abstract fun dataDao(): DataDao

    companion object {
        @Volatile
        private var INSTANCE: DataRoomDatabase? = null

        fun getDatabase(context: Context): DataRoomDatabase {
            return INSTANCE
                ?: synchronized(this) {
                    val instance = Room.databaseBuilder(context.applicationContext, DataRoomDatabase::class.java, "Kotlin")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries()
                        .build()
                    INSTANCE = instance
                    instance
                }
        }
    }

}
