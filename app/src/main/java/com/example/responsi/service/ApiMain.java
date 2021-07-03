package com.example.responsi.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiMain {
    private Retrofit retrofit;

    public KasusHarianRepository getApiKasusHarian(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(KasusHarianRepository.class);
    }

    public FasKesRepository getApiFasilitasKesehatan(){
        String BASE_URL = "https://covid19-public.digitalservice.id/api/v1/";
        if(retrofit==null){
            retrofit = new Retrofit
                    .Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit.create(FasKesRepository.class);
    }
}
