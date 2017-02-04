package com.example.human.nesada;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;
import com.example.human.model.Parks;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by nesada on 1/29/17.
 */

public class HlAdapterTwo extends RecyclerView.Adapter<HlViewHolderTwo> {

    List<Parks> parksList;

    public HlAdapterTwo(){
        parksList = new ArrayList<>();
    }

    @Override
    public HlViewHolderTwo onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.parks_cardview,parent,false);
        return new HlViewHolderTwo(view);
    }

    @Override
    public void onBindViewHolder(HlViewHolderTwo holder, int position) {
            Parks parks = parksList.get(position);
        holder.bind(parks);
    }

    @Override
    public int getItemCount() {
        return parksList.size();
    }

    public void  setParksList(List<Parks> mparkList){
        parksList.clear();
        parksList.addAll(mparkList);
        notifyDataSetChanged();
    }
}
