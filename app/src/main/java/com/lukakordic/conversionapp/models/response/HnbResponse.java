package com.lukakordic.conversionapp.models.response;

import com.lukakordic.conversionapp.models.data.Currency;

import java.util.ArrayList;
import java.util.List;

public class HnbResponse {

    private List<Currency> currencies = new ArrayList<>();

    public HnbResponse(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }
}
