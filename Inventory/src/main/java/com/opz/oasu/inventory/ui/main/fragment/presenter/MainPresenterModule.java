package com.opz.oasu.inventory.ui.main.fragment.presenter;

import com.opz.oasu.inventory.di.FragmentScope;

import dagger.Binds;
import dagger.Module;


@Module
public abstract class MainPresenterModule {

    @Binds
    @FragmentScope
    abstract MainPresenter mainPresenter(MainPresenterImpl mainPresenterImpl);
}
