package com.lukakordic.conversionapp.presentation;

import com.lukakordic.conversionapp.interaction.CurrencyInteractor;
import com.lukakordic.conversionapp.ui.CurrencyView;

import javax.inject.Inject;

public class CurrencyPresenterImpl implements CurrencyPresenter {

    private CurrencyInteractor currencyInteractor;
    private CurrencyView currencyView;

    @Inject
    public CurrencyPresenterImpl(CurrencyInteractor currencyInteractor) {
        this.currencyInteractor = currencyInteractor;
    }

    @Override
    public void setView(CurrencyView currencyView) {
        this.currencyView = currencyView;
    }

    @Override
    public void getCurrencies() {
        currencyInteractor.getCurrencies();
    }

    @Override
    public void calculateResult(double valueToConvert) {
        currencyView.showConversionResult(5.4342432);
    }
}
