package com.opz.oasu.inventory.ui.main.fragment.view;

import android.app.Fragment;

import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseFragmentModule;
import com.opz.oasu.inventory.ui.main.fragment.presenter.MainPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;


@Module(includes = {
        BaseFragmentModule.class,
        MainPresenterModule.class})
public abstract class MainFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @FragmentScope
    abstract Fragment fragment(MainFragment mainFragment);

    @Binds
    @FragmentScope
    abstract MainView mainView(MainFragment mainFragment);
}
