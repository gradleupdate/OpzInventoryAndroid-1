package com.opz.oasu.inventory.ui.details.fragment.view;

import android.app.Fragment;

import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseFragmentModule;
import com.opz.oasu.inventory.ui.details.fragment.presenter.DetailsPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;


@Module(includes = {
        BaseFragmentModule.class,
        DetailsPresenterModule.class})
public abstract class DetailsFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @FragmentScope
    abstract Fragment fragment(DetailsFragment mainFragment);

    @Binds
    @FragmentScope
    abstract DetailsView mainView(DetailsFragment mainFragment);
}
