package com.lukakordic.conversionapp.di.modules;

import com.lukakordic.conversionapp.interaction.CurrencyInteractor;
import com.lukakordic.conversionapp.interaction.CurrencyInteractorImpl;

import dagger.Binds;
import dagger.Module;

@Module(includes = NetworkingModule.class)
public abstract class InteractionModule {

    @Binds
    public abstract CurrencyInteractor provideInteractor(CurrencyInteractorImpl currencyInteractor);
}
