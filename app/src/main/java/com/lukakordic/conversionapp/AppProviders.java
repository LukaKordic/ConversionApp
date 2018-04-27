package com.lukakordic.conversionapp;

import com.lukakordic.conversionapp.presentation.CurrencyPresenter;

public class AppProviders {

    public static CurrencyPresenter currencyPresenter() {
        return App.getAppComponent().currencyPresenter();
    }
}
