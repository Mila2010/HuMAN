package com.example.human.asia.rv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;

/**
 * Created by asiagibson on 1/29/17.
 */

public class HlAdapter extends RecyclerView.Adapter<HlViewHolder> {

    @Override
    public HlViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.homeless_cardview,parent,false);
        return new HlViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HlViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
