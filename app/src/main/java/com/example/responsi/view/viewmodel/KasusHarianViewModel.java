package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.kasus_harian.ContentItem;
import com.example.responsi.model.kasus_harian.KasusHarianResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class KasusHarianViewModel extends ViewModel {
    private ApiMain apiMain;
    private MutableLiveData<ArrayList<ContentItem>> listKasusHarian = new MutableLiveData<>();

    public void setKasusHarian() {
        if(this.apiMain==null){
            apiMain = new ApiMain();
        }

        apiMain.getApiKasusHarian().getKasusHarian().enqueue(new Callback<KasusHarianResponse>() {
            @Override
            public void onResponse(Call<KasusHarianResponse> call, Response<KasusHarianResponse> response) {
                KasusHarianResponse kasusHarianRespone = response.body();
                if(kasusHarianRespone != null && kasusHarianRespone.getData() != null){
                    ArrayList<ContentItem> kasusharianItem = kasusHarianRespone.getData().getContent();
                    listKasusHarian.postValue(kasusharianItem);
                }
            }

            @Override
            public void onFailure(Call<KasusHarianResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<ContentItem>> getKasusHarian(){
        return listKasusHarian;
    }
}
