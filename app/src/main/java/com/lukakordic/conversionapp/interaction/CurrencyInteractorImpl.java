package com.lukakordic.conversionapp.interaction;

import android.widget.Toast;

import com.lukakordic.conversionapp.App;
import com.lukakordic.conversionapp.RetrofitCallback;
import com.lukakordic.conversionapp.api.HnbApiService;
import com.lukakordic.conversionapp.models.data.Currency;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyInteractorImpl implements CurrencyInteractor {

    private HnbApiService hnbApiService;

    @Inject
    public CurrencyInteractorImpl(HnbApiService hnbApiService) {
        this.hnbApiService = hnbApiService;
    }

    @Override
    public void getCurrencies(final RetrofitCallback retrofitCallback) {
        hnbApiService.getLatestConversionRates().enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                if (response.body() != null) {
                    retrofitCallback.onSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<List<Currency>> call, Throwable t) {
                t.printStackTrace();
                Toast.makeText(App.getApp(), "Failed request", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
