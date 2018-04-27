package com.lukakordic.conversionapp.api;

import com.lukakordic.conversionapp.models.response.HnbResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HnbApiService {

    @GET("rates/daily")
    public Call<HnbResponse> getLatestConversionRates();

    @GET("")
    public Call<HnbResponse> getConversionRatesByDate();
}
