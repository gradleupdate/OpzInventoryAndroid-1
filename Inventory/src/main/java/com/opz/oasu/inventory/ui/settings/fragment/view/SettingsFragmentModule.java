package com.opz.oasu.inventory.ui.settings.fragment.view;

import android.app.Fragment;

import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.view.MVPView;
import com.opz.oasu.inventory.ui.common.view.fragment.BaseFragmentModule;
import com.opz.oasu.inventory.ui.settings.fragment.presenter.SettingsPresenterModule;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;

@Module(includes = {
        BaseFragmentModule.class,
        SettingsPresenterModule.class})
public abstract class SettingsFragmentModule {

    @Binds
    @Named(BaseFragmentModule.FRAGMENT)
    @FragmentScope
    abstract Fragment fragment(SettingsFragment settingsFragment);

    @Binds
    @FragmentScope
    abstract SettingsView settingsView(SettingsFragment settingsFragment);

}
