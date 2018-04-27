package com.lukakordic.conversionapp.models.data;

import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("currency_code")
    private String currencyCode;

    @SerializedName("buying_rate")
    private double buyingRate;

    @SerializedName("selling_rate")
    private double sellingRate;

    @SerializedName("unit_value")
    private int unitValue;

    public Currency() {
    }

    public Currency(String currencyCode, double buyingRate, double sellingRate, int unitValue) {

        this.currencyCode = currencyCode;
        this.buyingRate = buyingRate;
        this.sellingRate = sellingRate;
        this.unitValue = unitValue;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public double getBuyingRate() {
        return buyingRate;
    }

    public void setBuyingRate(double buyingRate) {
        this.buyingRate = buyingRate;
    }

    public double getSellingRate() {
        return sellingRate;
    }

    public void setSellingRate(double sellingRate) {
        this.sellingRate = sellingRate;
    }

    public int getUnitValue() {
        return unitValue;
    }

    public void setUnitValue(int unitValue) {
        this.unitValue = unitValue;
    }
}
