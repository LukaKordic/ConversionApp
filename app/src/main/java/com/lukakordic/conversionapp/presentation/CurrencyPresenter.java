package com.lukakordic.conversionapp.presentation;

import com.lukakordic.conversionapp.ui.CurrencyView;

public interface CurrencyPresenter {

    void setView(CurrencyView currencyView);

    void getCurrencies();

    void calculateResult(double valueToConvert);
}
