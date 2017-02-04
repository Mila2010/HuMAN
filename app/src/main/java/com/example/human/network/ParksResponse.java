package com.example.human.network;


import com.example.human.model.Parks;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by nesada on 1/28/17.
 */

public interface ParksResponse {

    @GET("resource/4xyq-5bdm.json")
    Call<List<Parks>> getParks();


}
