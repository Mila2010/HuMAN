package com.example.human.homless

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.human.R
import com.example.human.model.Shelters

class HomelessAdapter(): RecyclerView.Adapter<HomelessViewHolder>() {

    private val sheltersList = mutableListOf<Shelters>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomelessViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.homeless_cardview, parent, false)
        return HomelessViewHolder(view)
    }

    override fun getItemCount(): Int = sheltersList.size

    override fun onBindViewHolder(holder: HomelessViewHolder, position: Int) {
        holder.bind(sheltersList[position])
    }

    fun getSheltersList(): List<Shelters> = sheltersList

    fun setSheltersList(mshelterList: List<Shelters>) {
        sheltersList.clear()
        sheltersList.addAll(mshelterList)
        notifyDataSetChanged()
    }

}