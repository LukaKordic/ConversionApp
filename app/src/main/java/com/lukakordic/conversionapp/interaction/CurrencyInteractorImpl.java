package com.lukakordic.conversionapp.interaction;

import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;

import com.lukakordic.conversionapp.App;
import com.lukakordic.conversionapp.api.HnbApiService;
import com.lukakordic.conversionapp.models.data.Currency;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CurrencyInteractorImpl implements CurrencyInteractor {

    private static final String TAG = "Luka";
    private HnbApiService hnbApiService;

    @Inject
    public CurrencyInteractorImpl(HnbApiService hnbApiService) {
        this.hnbApiService = hnbApiService;
    }

    @Override
    public void getCurrencies() {
        hnbApiService.getLatestConversionRates().enqueue(new Callback<List<Currency>>() {
            @Override
            public void onResponse(Call<List<Currency>> call, Response<List<Currency>> response) {
                if (response.body() != null) {
                    for (Currency currency :
                            response.body()) {
                        Log.d(TAG, "onResponse: " + currency.getCurrencyCode());
                    }
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
