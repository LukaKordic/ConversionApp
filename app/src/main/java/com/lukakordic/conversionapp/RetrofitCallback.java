package com.lukakordic.conversionapp;

import com.lukakordic.conversionapp.models.data.Currency;

import java.util.List;

public interface RetrofitCallback {

    void onSuccess(List<Currency> apiResponse);
}
