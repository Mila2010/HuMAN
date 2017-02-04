package com.example.human.nesada;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.human.R;
import com.example.human.model.Parks;


/**
 * Created by nesada on 1/29/17.
 */

public class HlViewHolderTwo extends RecyclerView.ViewHolder {

    private Context mContext;

    TextView name, location,type;



    public HlViewHolderTwo(View itemView) {
        super(itemView);

        name = (TextView) itemView.findViewById(R.id.name);
        location = (TextView) itemView.findViewById(R.id.location);
        type = (TextView) itemView.findViewById(R.id.type);


    }

    public void bind (Parks shelters){
        name.setText( shelters.getName());
        location.setText( shelters.getLocation());
        type.setText(shelters.getType());

    }


}
