package com.example.responsi.service;

import com.example.responsi.model.fas_kes.FasKesResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FasKesRepository {
    @GET("sebaran_v2/jabar/faskes")
    Call<FasKesResponse> getFasilitasKesehatan();
}
