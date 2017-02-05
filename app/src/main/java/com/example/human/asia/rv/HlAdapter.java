package com.example.human.asia.rv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;
import com.example.human.model.Shelters;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by asiagibson on 1/29/17.
 */

public class HlAdapter extends RecyclerView.Adapter<HlViewHolder> {

    List<Shelters> sheltersList;

    public HlAdapter() {
        sheltersList = new ArrayList<>();
    }

    @Override
    public HlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeless_cardview, parent, false);
        return new HlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HlViewHolder holder, int position) {
        Shelters shelters = sheltersList.get(position);
        holder.bind(shelters);
    }
    public void updateList(List<Shelters> list){
        sheltersList = list;
        notifyDataSetChanged();
    }



    @Override
    public int getItemCount() {
        return sheltersList.size();
    }

    public void setSheltersList(List<Shelters> mshelterList) {
        sheltersList.clear();
        sheltersList.addAll(mshelterList);
        notifyDataSetChanged();
    }


    public List<Shelters> getSheltersList() {
        return sheltersList;
    }
}
