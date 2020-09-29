package com.example.roomdatabaseappkotlin.PagesPackage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.roomdatabaseappkotlin.CustomApdatersPackage.CustomAdapterInfraListFavorites
import com.example.roomdatabaseappkotlin.R
import com.example.roomdatabaseappkotlin.RoomPackage.DataViewModel
import kotlinx.android.synthetic.main.activity_favorites.*

class FavoritesActivity : AppCompatActivity() {

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_favorites)

        getData()
    }

    private fun getData() {
        val dataViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
        dataViewModel.allData.observe(this, { data ->
            data?.let {
                val adapter = CustomAdapterInfraListFavorites(it)
                recyclerview.layoutManager = LinearLayoutManager(this)
                recyclerview.adapter = adapter
            }
        })
    }

}
