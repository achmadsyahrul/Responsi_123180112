package com.example.responsi.model.kasus_harian;

import com.google.gson.annotations.SerializedName;

public class KasusHarianResponse{

	@SerializedName("status_code")
	private int statusCode;

	@SerializedName("data")
	private Data data;

	public int getStatusCode(){
		return statusCode;
	}

	public Data getData(){
		return data;
	}
}