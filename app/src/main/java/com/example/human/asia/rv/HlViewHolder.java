package com.example.human.asia.rv;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.human.R;
import com.example.human.model.Shelters;

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



    public HlViewHolder(View itemView) {
        super(itemView);

        address = (TextView) itemView.findViewById(R.id.adress);
        borough = (TextView) itemView.findViewById(R.id.borough);
        commDistrict = (TextView) itemView.findViewById(R.id.community_district);
        homeOffice = (TextView) itemView.findViewById(R.id.homebase_office);
        neighborhood = (TextView) itemView.findViewById(R.id.neighborhood);
        phone = (TextView) itemView.findViewById(R.id.phone_number);

    }

    public void bind (Shelters shelters){
        address.setText(shelters.getAddress());
//        borough.setText();
//        commDistrict.setText();
//        homeOffice.setText();
//        neighborhood.setText();
//        phone.setText();
    }


}
