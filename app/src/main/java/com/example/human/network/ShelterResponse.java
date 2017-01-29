package com.example.human.network;

import com.example.human.model.Shelters;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Millochka on 1/28/17.
 */

public interface ShelterResponse {

    @GET("resource/5ud2-iqje.json")
    Call<List<Shelters>> getShelters();

}
