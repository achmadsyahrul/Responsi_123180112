package com.example.responsi.model.fas_kes;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.SerializedName;

public class FasKesResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private ArrayList<DataItem> data;

	public int getStatusCode(){
		return statusCode;
	}

	public ArrayList<DataItem> getData(){
		return data;
	}
}