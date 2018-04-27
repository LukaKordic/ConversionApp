package com.lukakordic.conversionapp.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.lukakordic.conversionapp.AppProviders;
import com.lukakordic.conversionapp.R;
import com.lukakordic.conversionapp.presentation.CurrencyPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConvertActivity extends AppCompatActivity implements CurrencyView {

    @BindView(R.id.from_currency)
    Spinner fromCurrency;

    @BindView(R.id.to_currency)
    Spinner toCurrency;

    @BindView(R.id.value_to_convert)
    EditText valueToConvert;

    @BindView(R.id.conversion_result)
    TextView conversionResult;

    private CurrencyPresenter currencyPresenter = AppProviders.currencyPresenter();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);

        ButterKnife.bind(this);

        initSpinners();

        currencyPresenter.setView(this);
    }

    private void initSpinners() {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.currencies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        fromCurrency.setAdapter(adapter);
        toCurrency.setAdapter(adapter);
    }

    @Override
    public void showConversionResult(double result) {
        conversionResult.setText(String.valueOf(result));
    }

    @OnClick(R.id.submit_button)
    public void convertValues() {
        if (!valueToConvert.getText().toString().isEmpty()) {
            double value = Double.parseDouble(valueToConvert.getText().toString());
            currencyPresenter.calculateResult(value);
        } else {
            valueToConvert.setError(getString(R.string.no_value_error));
        }
    }
}
