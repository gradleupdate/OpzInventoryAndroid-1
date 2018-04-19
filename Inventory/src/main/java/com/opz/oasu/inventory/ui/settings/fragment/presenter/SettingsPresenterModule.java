package com.opz.oasu.inventory.ui.settings.fragment.presenter;

import com.opz.oasu.inventory.di.FragmentScope;

import dagger.Binds;
import dagger.Module;

@Module
public abstract class SettingsPresenterModule {

    @Binds
    @FragmentScope
    abstract SettingsPresenter settingsPresenter(SettingsPresenterImpl settingsPresenterImpl);
}
