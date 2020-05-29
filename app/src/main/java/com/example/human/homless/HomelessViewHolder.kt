package com.example.human.homless

import android.content.Intent
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.human.R
import com.example.human.maps.MapsActivity
import com.example.human.model.Shelters

class HomelessViewHolder(view: View): ViewHolder(view) {

    private val googleMaps = itemView.findViewById<ImageView>(R.id.maps)
    private val address = itemView.findViewById<TextView>(R.id.adress)
    private val commDistrict = itemView.findViewById<TextView>(R.id.community_district)
    private val borough = itemView.findViewById<TextView>(R.id.borough)
    private val homeOffice = itemView.findViewById<TextView>(R.id.homebase_office)
    private val neighborhood = itemView.findViewById<TextView>(R.id.neighborhood)
    private val phone = itemView.findViewById<TextView>(R.id.phone_number)



    fun bind(shelters: Shelters) {
        address.text = "Address: ${shelters.address}"
        borough.text = "Borough: ${shelters.borough}"
        commDistrict.text = "Community Dist: ${shelters.community_district}"
        homeOffice.text = "Homebase Office: ${shelters.homebase_office}"
        neighborhood.text = "Neighborhood: ${shelters.neighborhood}"
        phone.text = "Phone: ${shelters.phone_number}"

        googleMaps.setOnClickListener { view ->
            if (adapterPosition == 0)
                view.context.startActivity(Intent(view.context, MapsActivity::class.java))

            }
        }

}