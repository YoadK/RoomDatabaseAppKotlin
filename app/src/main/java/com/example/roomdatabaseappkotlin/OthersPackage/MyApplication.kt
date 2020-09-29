package com.example.roomdatabaseappkotlin.OthersPackage

import android.app.Application

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        mApplication = this
    }

    companion object {
        private var mApplication: Application? = null

        fun getApplication(): Application? {
            return mApplication
        }
    }

}
