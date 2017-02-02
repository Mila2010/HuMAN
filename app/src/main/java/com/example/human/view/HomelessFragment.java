package com.example.human.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.human.R;

import com.example.human.asia.rv.HlAdapter;
import com.example.human.model.Shelters;
import com.example.human.network.ShelterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomelessFragment extends android.support.v4.app.Fragment {

    RecyclerView rv;
    HlAdapter adapter;

    private static final String WORKING = "Hemless";
    private static final String NOTWORKING = "HomlessNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";
    private TextView test;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View itemView = inflater.inflate(R.layout.hm_option_view, container, false);

//        rv = (RecyclerView) itemView.findViewById(R.id.recyclerview);
//        adapter = new HlAdapter();
//        rv.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.VERTICAL, false));
//        rv.setAdapter(adapter);
//
        return itemView;


    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       // test = (TextView) view.findViewById(R.id.tab_text);
//        mRetrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
//
//        ShelterResponse shelterResponse = mRetrofit.create(ShelterResponse.class);
//
//        Call<List<Shelters>> call = shelterResponse.getShelters();
//
//        call.enqueue(new Callback<List<Shelters>>() {
//            @Override
//            public void onResponse(Call<List<Shelters>> call, Response<List<Shelters>> response) {
//
//                if (response.isSuccessful()) {
//
//                    //ResponseBody body=response.body();
//
//                    //ListOfShelters listOfShelters = response.body();
//
//                    List<Shelters> shelterses = response.body();
////
////                    String myresponse = shelterses.get(0).getAddress();
//
//                    Log.d(WORKING, "It is workig");
//
//                    adapter.setSheltersList(shelterses);
//                    // test.setText(shelterses.get(0).getAddress());
//
//
//                }

            }

//            @Override
//            public void onFailure(Call<List<Shelters>> call, Throwable t) {
//                System.out.print("Not working");
//                Log.d(NOTWORKING, "It is not workig");
//
//            }
//        });
//
//
//    }
}




