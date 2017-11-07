package com.opz.oasu.inventory;

import android.app.Application;

import javax.inject.Singleton;

import dagger.Binds;
import dagger.Module;
import dagger.android.AndroidInjectionModule;
import dagger.android.ContributesAndroidInjector;
import com.opz.oasu.inventory.di.ActivityScope;
import com.opz.oasu.inventory.ui.main.MainActivity;
import com.opz.oasu.inventory.ui.main.MainActivityModule;
import com.opz.oasu.inventory.ui.settings.SettingsActivity;
import com.opz.oasu.inventory.ui.settings.SettingsActivityModule;
import com.opz.oasu.inventory.ui.start.StartActivity;
import com.opz.oasu.inventory.ui.start.StartActivityModule;

@Module(includes = AndroidInjectionModule.class)
abstract class InventoryAppModule {

    @Binds
    @Singleton
    abstract Application application(InventoryApp inventoryApp);

    @ActivityScope
    @ContributesAndroidInjector(modules = StartActivityModule.class)
    abstract StartActivity startActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivityInjector();

    @ActivityScope
    @ContributesAndroidInjector(modules = SettingsActivityModule.class)
    abstract SettingsActivity settingsActivityInjector();

}
