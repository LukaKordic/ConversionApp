package com.lukakordic.conversionapp.interaction;

import com.lukakordic.conversionapp.models.data.Currency;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class CurrencyInteractorImpl implements CurrencyInteractor {

    @Inject
    public CurrencyInteractorImpl() {
    }

    @Override
    public List<Currency> getCurrencies() {
        return new ArrayList<>();
    }
}
