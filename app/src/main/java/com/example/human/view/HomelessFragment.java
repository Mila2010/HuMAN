package com.example.human.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.human.R;
import com.example.human.model.Shelters;
import com.example.human.network.ShelterResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HomelessFragment extends Fragment {

    private static final String WORKING ="Hemless" ;
    private static final String NOTWORKING = "HomlessNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL="https://data.cityofnewyork.us/";
    private TextView test;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.homeless_service_fragment, container, false);
    }

    @Override
    public  void onViewCreated(View view, Bundle savedInstanceState){
        super.onViewCreated(view,savedInstanceState);
        test=(TextView) view.findViewById(R.id.tab_text);
        mRetrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();

        ShelterResponse shelterResponse = mRetrofit.create(ShelterResponse.class);

        Call<List<Shelters>> call= shelterResponse.getShelters();

        call.enqueue(new Callback<List<Shelters>>() {
            @Override
            public void onResponse(Call<List<Shelters>> call, Response<List<Shelters>> response) {

                if(response.isSuccessful()){

                    //ResponseBody body=response.body();

                    //ListOfShelters listOfShelters = response.body();

                    List<Shelters> shelterses=response.body();
//
//                    String myresponse = shelterses.get(0).getAddress();

                    Log.d(WORKING,"It is workig");


                        test.setText(shelterses.get(0).getAddress());



                }

            }

            @Override
            public void onFailure(Call<List<Shelters>> call, Throwable t) {
                System.out.print("Not working");
                Log.d(NOTWORKING,"It is not workig");

            }
        });


    }
}



