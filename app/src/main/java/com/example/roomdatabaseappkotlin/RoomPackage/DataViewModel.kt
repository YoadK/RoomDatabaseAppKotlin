package com.example.roomdatabaseappkotlin.RoomPackage

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

// contains: "repository: DataRepository", "allData: LiveData<List<DataModelRoom>>", "DAO" variables.

// "repository: DataRepository" is used for: init and create the repository
// "allData: LiveData<List<DataModelRoom>>" is used for: store the whole data in one variable (list with data)
// "DAO" is used for: init and build the room database

class DataViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: DataRepository
    val allData: LiveData<List<DataModelRoom>>

    init {
        val dataDao = DataRoomDatabase.getDatabase(application).dataDao()
        repository = DataRepository(dataDao) //??
        //allData = repository.allData
        allData = repository.getAll();
    }

    fun insert(dataModelRoom: DataModelRoom) = viewModelScope.launch {
        repository.insert(dataModelRoom)
    }

    fun update(dataModelRoom: DataModelRoom) = viewModelScope.launch {
        repository.update(dataModelRoom)
    }

    fun delete() = viewModelScope.launch {
        repository.delete()
    }

    fun deleteAll() = viewModelScope.launch {
        repository.deleteAll()
    }

}
