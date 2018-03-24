package com.example.human.homless;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.human.R;
import com.example.human.model.Shelters;
import com.example.human.maps.MapsActivity;

/**
 * Created by asiagibson on 1/29/17.
 */

public class HlViewHolder extends RecyclerView.ViewHolder {

    private Context mContext;

    TextView address;
    TextView borough;
    TextView commDistrict;
    TextView homeOffice;
    TextView neighborhood;
    TextView phone;
    ImageView googleMaps;



    public HlViewHolder(View itemView) {
        super(itemView);

        mContext = itemView.getContext();
        googleMaps = (ImageView) itemView.findViewById(R.id.maps);
        address = (TextView) itemView.findViewById(R.id.adress);
        borough = (TextView) itemView.findViewById(R.id.borough);
        commDistrict = (TextView) itemView.findViewById(R.id.community_district);
        homeOffice = (TextView) itemView.findViewById(R.id.homebase_office);
        neighborhood = (TextView) itemView.findViewById(R.id.neighborhood);
        phone = (TextView) itemView.findViewById(R.id.phone_number);

        googleMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent;
                switch (getAdapterPosition()) {
                    case 0:
                        intent = new Intent(mContext, MapsActivity.class);
                        mContext.startActivity(intent);
                        break;

                }
            }
        });

    }

    public void bind (Shelters shelters){
        address.setText("Address: " + shelters.getAddress());
        borough.setText("Borough: " + shelters.getBorough());
        commDistrict.setText("Community Dist: " + shelters.getCommunity_district());
        homeOffice.setText("Homebase Office: " + shelters.getHomebase_office());
        neighborhood.setText("Neighborhood: " + shelters.getNeighborhood());
        phone.setText("Phone: " + shelters.getPhone_number());
    }


}
