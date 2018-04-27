package com.lukakordic.conversionapp.presentation;

import com.lukakordic.conversionapp.ui.CurrencyView;

public interface CurrencyPresenter {

    void setView(CurrencyView currencyView);

    void calculateResult(String fromCurrency, String toCurrency, double valueToConvert);

    void getCurrencyRates();
}
