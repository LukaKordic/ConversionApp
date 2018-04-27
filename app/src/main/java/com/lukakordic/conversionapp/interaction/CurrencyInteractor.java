package com.lukakordic.conversionapp.interaction;

import com.lukakordic.conversionapp.RetrofitCallback;

public interface CurrencyInteractor {

    void getCurrencies(final RetrofitCallback retrofitCallback);
}
