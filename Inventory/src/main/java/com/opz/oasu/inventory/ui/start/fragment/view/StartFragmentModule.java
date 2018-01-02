package com.opz.oasu.inventory.ui.start.fragment.view;

import android.app.Fragment;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseFragmentModule;
import com.opz.oasu.inventory.ui.start.fragment.presenter.StartPresenterModule;


@Module(includes = {
        BaseFragmentModule.class,
        StartPresenterModule.class})
public abstract class StartFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @FragmentScope
    abstract Fragment fragment(StartFragment startFragment);

    @Binds
    @FragmentScope
    abstract StartView startView(StartFragment startFragment);

    @Binds
    @FragmentScope
    abstract StartFragmentActionListener startFragmentActionListener(StartFragment startFragment);
}
