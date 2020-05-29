package com.example.human.homless;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.SearchView;

import com.example.human.R;
import com.example.human.model.Shelters;
import com.example.human.network.ShelterResponse;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

;

/**
 * Created by asiagibson on 1/30/17.
 */

public class HomelessOptionsFragment extends Fragment {
    RecyclerView rv;
    HomelessAdapter adapter;

    private static final String WORKING = "Hemless";
    private static final String NOTWORKING = "HomlessNotWorking";
    private Retrofit mRetrofit;
    private final String BASEURL = "https://data.cityofnewyork.us/";
    EditText searchField;
    private SwipeRefreshLayout mSwipeRefreshLayout;
    private SearchView mSearch;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {




        View view = inflater.inflate(R.layout.homeless_service_fragment, container, false);

        rv = view.findViewById(R.id.recyclerview);
        adapter = new HomelessAdapter();
        rv.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        rv.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mSearch=view.findViewById(R.id.search_shelter);
        mSearch.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            List<Shelters> temp = adapter.getSheltersList();
            @Override
            public boolean onQueryTextSubmit(String query) {
                filter(query.toString(), temp);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                filter(newText.toString(), temp);
                return true;
            }
        });

        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                // Refresh items
                refreshItems();
            }
        });



        mRetrofit = new Retrofit.Builder().baseUrl(BASEURL).addConverterFactory(GsonConverterFactory.create()).build();
        startRetrofit(mRetrofit);



    }


    public void filter(String text, List<Shelters> list){
        final List<Shelters> temp = new ArrayList();
        for(Shelters d: list){
            if(d.getNeighborhood().toLowerCase().contains(text.toLowerCase())){
                temp.add(d);
            }
        }
        //update recyclerview
        adapter.setSheltersList(temp);
    }

    public void refreshItems() {
        startRetrofit(mRetrofit);
        adapter.notifyDataSetChanged();
        onItemsLoadComplete();

    }

    public void onItemsLoadComplete() {
        // Update the adapter and notify data set changed
        // ...

        // Stop refresh animation
        mSwipeRefreshLayout.setRefreshing(false);
    }

    public void startRetrofit(Retrofit retrofit){

        ShelterResponse shelterResponse = retrofit.create(ShelterResponse.class);

        Call<List<Shelters>> call = shelterResponse.getShelters();

        call.enqueue(new Callback<List<Shelters>>() {
            @Override
            public void onResponse(Call<List<Shelters>> call, Response<List<Shelters>> response) {

                if (response.isSuccessful()) {


                    List<Shelters> shelterses = response.body();

                    Log.d(WORKING, "It is working");

                    adapter.setSheltersList(shelterses);


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
