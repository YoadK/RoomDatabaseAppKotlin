package com.example.roomdatabaseappkotlin.RoomPackage

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DataDao {

    @Query("SELECT * from Kotlin")
    fun getAll(): LiveData<List<DataModelRoom>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(dataModelRoom: DataModelRoom)

    @Update
    fun update(dataModelRoom: DataModelRoom)

    @Query("DELETE From Kotlin where first_name = first_name")
    fun deleteItem()

    @Query("DELETE FROM Kotlin")
    fun deleteAll()
}
