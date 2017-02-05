package com.example.human.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;
import com.example.human.model.Parks;
import com.example.human.nesada.HlAdapterTwo;
import com.example.human.network.ParksResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Millochka on 1/27/17.
 */
public class NesadaFragment extends Fragment {
    RecyclerView rv;
    HlAdapterTwo adapter;

    private static final String WORKING = "Parks";
    private static final String NOTWORKING = "ParksNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nesada_service_fragment, container, false);

        rv = (RecyclerView) view.findViewById(R.id.recyclerview);
        adapter = new HlAdapterTwo();
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRetrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

        ParksResponse parksResponse = mRetrofit.create(ParksResponse.class);

        Call<List<Parks>> call = parksResponse.getParks();

        call.enqueue(new Callback<List<Parks>>() {
            @Override
            public void onResponse(Call<List<Parks>> call, Response<List<Parks>> response) {
                if (response.isSuccessful()) {
                    List<Parks> parks = response.body();

//                    try {
//                        Log.d(WORKING, "WORKING"+ parks.string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
                    adapter.setParksList(parks);

                }
            }


            @Override
            public void onFailure(Call<List<Parks>> call, Throwable t) {
                System.out.print("Not WORKING");
                Log.d(NOTWORKING, "Not WORKING");

            }
        });


    }

}


//    @Override
//    public View onCreateView(LayoutInflater inflater,
//                             ViewGroup container, Bundle savedInstanceState) {
//        View rootView = inflater.inflate(
//                R.layout.nesada_service_fragment, container, false);
//
//        return rootView;



