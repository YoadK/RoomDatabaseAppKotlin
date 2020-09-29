package com.example.roomdatabaseappkotlin.CustomApdatersPackage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.roomdatabaseappkotlin.R
import com.example.roomdatabaseappkotlin.RoomPackage.DataModelRoom
import kotlinx.android.synthetic.main.adapter_data.view.*

class CustomAdapterInfraListFavorites internal constructor(private var dataModelRooms: List<DataModelRoom>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.adapter_data, parent, false)
        return PartViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PartViewHolder).bind(dataModelRooms[position])
    }

    class PartViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(part: DataModelRoom) {
            itemView.firstName.text = "First Name: " + part.firstName
            itemView.lastName.text = "Last Name: " + part.lastName
        }
    }

    override fun getItemCount() = dataModelRooms.size
}

