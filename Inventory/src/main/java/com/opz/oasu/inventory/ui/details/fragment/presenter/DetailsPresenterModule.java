package com.opz.oasu.inventory.ui.details.fragment.presenter;

import com.opz.oasu.inventory.di.FragmentScope;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class DetailsPresenterModule {

    @Binds
    @FragmentScope
    abstract DetailsPresenter mainPresenter(DetailsPresenterImpl mainPresenterImpl);
}
