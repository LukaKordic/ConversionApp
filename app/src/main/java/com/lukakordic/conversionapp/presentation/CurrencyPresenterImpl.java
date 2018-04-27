package com.lukakordic.conversionapp.presentation;

import com.lukakordic.conversionapp.RetrofitCallback;
import com.lukakordic.conversionapp.interaction.CurrencyInteractor;
import com.lukakordic.conversionapp.models.data.Currency;
import com.lukakordic.conversionapp.ui.CurrencyView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CurrencyPresenterImpl implements CurrencyPresenter, RetrofitCallback {

    private List<Currency> currencies = new ArrayList<>();

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
    public void getCurrencyRates() {
        currencyInteractor.getCurrencies(this);
    }

    @Override
    public void onSuccess(List<Currency> apiResponse) {
        currencies.clear();
        currencies.addAll(apiResponse);
    }

    @Override
    public void calculateResult(String fromCurrency, String toCurrency, double valueToConvert) {
        double result;
        double buyingRate = 0;
        double sellingRate = 0;
        int unitValue = 0;

        if (!fromCurrency.equals(toCurrency)) {
            if (!fromCurrency.equals("HRK") && !toCurrency.equals("HRK")) {
                for (Currency currency : currencies) {
                    if (currency.getCurrencyCode().equals(toCurrency)) {
                        sellingRate = currency.getSellingRate();
                        unitValue = currency.getUnitValue();
                    } else if (currency.getCurrencyCode().equals(fromCurrency)) {
                        buyingRate = currency.getBuyingRate();
                        unitValue = currency.getUnitValue();
                    }
                }
                result = ((valueToConvert * unitValue) * buyingRate) / sellingRate;
                currencyView.showConversionResult(result);
            } else if (fromCurrency.equals("HRK")) {
                for (Currency currency : currencies) {
                    if (currency.getCurrencyCode().equals(toCurrency)) {
                        sellingRate = currency.getSellingRate();
                        unitValue = currency.getUnitValue();
                    }
                }
                result = (valueToConvert * unitValue) / sellingRate;
                currencyView.showConversionResult(result);
            } else if (toCurrency.equals("HRK")) {
                for (Currency currency : currencies) {
                    if (currency.getCurrencyCode().equals(fromCurrency)) {
                        buyingRate = currency.getBuyingRate();
                        unitValue = currency.getUnitValue();
                    }
                }
                result = (valueToConvert / unitValue) * buyingRate;
                currencyView.showConversionResult(result);
            }
        } else {
            currencyView.showConversionResult(valueToConvert);
        }
    }
}


