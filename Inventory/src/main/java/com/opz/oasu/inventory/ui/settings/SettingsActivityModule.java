package com.opz.oasu.inventory.ui.settings;

import android.app.Activity;

import com.opz.oasu.inventory.di.ActivityScope;
import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.BaseActivityModule;
import com.opz.oasu.inventory.ui.settings.fragment.view.SettingsFragment;
import com.opz.oasu.inventory.ui.settings.fragment.view.SettingsFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module(includes = BaseActivityModule.class)
public abstract class SettingsActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = SettingsFragmentModule.class)
    abstract SettingsFragment settingsFragmentInjector();

    @Binds
    @ActivityScope
    abstract Activity activity(SettingsActivity settingsActivity);
}
