package com.example.responsi.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.responsi.model.fas_kes.DataItem;
import com.example.responsi.model.fas_kes.FasKesResponse;
import com.example.responsi.service.ApiMain;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FasKesViewModel extends ViewModel {
    private ApiMain apiMain;

    private MutableLiveData<ArrayList<DataItem>> listFasKes = new MutableLiveData<>();

    public void setFasKes(){
        if (this.apiMain == null){
            apiMain = new ApiMain();
        }

        apiMain.getApiFasilitasKesehatan().getFasilitasKesehatan().enqueue(new Callback<FasKesResponse>() {
            @Override
            public void onResponse(Call<FasKesResponse> call, Response<FasKesResponse> response) {
                FasKesResponse fasKesResponse  = response.body();
                if (fasKesResponse != null){
                    ArrayList<DataItem> fasKesItem = fasKesResponse.getData();
                    listFasKes.postValue(fasKesItem);
                }
            }

            @Override
            public void onFailure(Call<FasKesResponse> call, Throwable t) {

            }
        });
    }

    public LiveData<ArrayList<DataItem>> getFasKes(){
        return listFasKes;
    }
}
