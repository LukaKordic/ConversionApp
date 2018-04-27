package com.lukakordic.conversionapp.di.modules;

import com.lukakordic.conversionapp.presentation.CurrencyPresenter;
import com.lukakordic.conversionapp.presentation.CurrencyPresenterImpl;

import dagger.Binds;
import dagger.Module;

@Module(includes = InteractionModule.class)
public abstract class PresentationModule {

    @Binds
    public abstract CurrencyPresenter providePresenter(CurrencyPresenterImpl currencyPresenter);
}
