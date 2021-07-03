package com.example.responsi.service;

import com.example.responsi.model.kasus_harian.KasusHarianResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface KasusHarianRepository {
    @GET("rekapitulasi_v2/jabar/harian")
    Call<KasusHarianResponse> getKasusHarian();
}
