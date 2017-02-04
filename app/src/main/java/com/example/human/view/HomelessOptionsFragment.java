package com.example.human.view;

import android.support.v4.app.Fragment;;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;
import com.example.human.asia.rv.HlAdapter;
import com.example.human.model.Shelters;
import com.example.human.network.ShelterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by asiagibson on 1/30/17.
 */

public class HomelessOptionsFragment extends Fragment {
    RecyclerView rv;
    HlAdapter adapter;

    private static final String WORKING = "Hemless";
    private static final String NOTWORKING = "HomlessNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";
    CardView dropin;
    CardView famShelter;
    CardView runaways;
    CardView lgbtq;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.homeless_service_fragment, container, false);

        rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        adapter = new HlAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRetrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

        ShelterResponse shelterResponse = mRetrofit.create(ShelterResponse.class);

        Call<List<Shelters>> call = shelterResponse.getShelters();

        call.enqueue(new Callback<List<Shelters>>() {
            @Override
            public void onResponse(Call<List<Shelters>> call, Response<List<Shelters>> response) {

                if (response.isSuccessful()) {


                    List<Shelters> shelterses = response.body();

                    Log.d(WORKING, "It is working");

                    adapter.setSheltersList(shelterses);
                    // test.setText(shelterses.get(0).getAddress());


                }

            }

            @Override
            public void onFailure(Call<List<Shelters>> call, Throwable t) {
                System.out.print("Not working");
                Log.d(NOTWORKING, "It is not workig");

            }
        });


    }

}
