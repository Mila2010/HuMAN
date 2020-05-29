package com.example.human.disabled;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.human.R;
import com.example.human.model.Parks;
import com.example.human.network.ParksResponse;

import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Millochka on 1/27/17.
 */
public class ParksFragment extends Fragment {
    RecyclerView rv;
    ParksAdapter adapter;

    private static final String WORKING = "Parks";
    private static final String NOTWORKING = "ParksNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.nesada_service_fragment, container, false);

        rv =  view.findViewById(R.id.recyclerview);
        adapter = new ParksAdapter();
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




