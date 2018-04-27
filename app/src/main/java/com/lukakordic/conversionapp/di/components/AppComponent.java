package com.lukakordic.conversionapp.di.components;

import com.lukakordic.conversionapp.di.modules.PresentationModule;
import com.lukakordic.conversionapp.presentation.CurrencyPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Component(modules = PresentationModule.class)
@Singleton
public interface AppComponent {

    CurrencyPresenter currencyPresenter();
}
