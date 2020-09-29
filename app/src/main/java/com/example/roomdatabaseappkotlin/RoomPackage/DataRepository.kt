package com.example.roomdatabaseappkotlin.RoomPackage

import androidx.lifecycle.LiveData

//contains "DAO" and "allData": LiveData<List<DataModelRoom>>
//uses DAO  to implements DB methods in java code
//uses  "allData" ...

class DataRepository(private val dataDao: DataDao) {

    //?? why do we need "allData" down below and not "getAll" method in line 16 ??
    //val allData: LiveData<List<DataModelRoom>> = dataDao.getAll()

    fun getAll(): LiveData<List<DataModelRoom>> {
        return dataDao.getAll()
    }

    fun insert(dataModelRoom: DataModelRoom) {
        dataDao.insert(dataModelRoom)
    }

    fun update(dataModelRoom: DataModelRoom) {
        dataDao.update(dataModelRoom)
    }

    fun delete() {
        dataDao.deleteItem()
    }

    fun deleteAll() {
        dataDao.deleteAll()
    }

}
