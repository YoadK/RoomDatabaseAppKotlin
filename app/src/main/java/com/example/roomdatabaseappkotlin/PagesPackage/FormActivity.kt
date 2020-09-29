package com.example.roomdatabaseappkotlin.PagesPackage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabaseappkotlin.OthersPackage.MyApplication
import com.example.roomdatabaseappkotlin.R
import com.example.roomdatabaseappkotlin.RoomPackage.DataModelRoom
import com.example.roomdatabaseappkotlin.RoomPackage.DataViewModel
import kotlinx.android.synthetic.main.activity_form.*

class FormActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        buttons()
    }

    private fun buttons() {
        btnView.setOnClickListener {
            startActivity(Intent(this, FavoritesActivity::class.java))
        }

        btnSave.setOnClickListener {
            val dataName = DataModelRoom(etFirstName.text.toString(), etLastName.text.toString())
            //val infraViewModel = MyApplication.getApplication()?.let { DataViewModel(it) }!!
            //infraViewModel.insert(dataName)

            //?? why not using lines below instead of lines 30+31 ?? ), and then we dont need the othersPackage/MyApplication
            val mViewModel = ViewModelProvider(this).get(DataViewModel::class.java)
            mViewModel.insert(dataName)

            startActivity(Intent(this, FavoritesActivity::class.java))
        }
    }

}
