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
}
