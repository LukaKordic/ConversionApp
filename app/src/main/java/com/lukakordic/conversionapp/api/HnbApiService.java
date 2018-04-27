package com.lukakordic.conversionapp.api;

import com.lukakordic.conversionapp.models.response.HnbResponse;

import com.lukakordic.conversionapp.models.data.Currency;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface HnbApiService {

    @GET("rates/daily")
    Call<List<Currency>> getLatestConversionRates();

    @GET("")
    Call<HnbResponse> getConversionRatesByDate();
}
