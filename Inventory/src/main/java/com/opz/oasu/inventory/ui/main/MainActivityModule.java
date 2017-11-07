package com.opz.oasu.inventory.ui.main;

import android.app.Activity;

import com.opz.oasu.inventory.di.ActivityScope;
import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.BaseActivityModule;
import com.opz.oasu.inventory.ui.main.fragment.view.MainFragment;
import com.opz.oasu.inventory.ui.main.fragment.view.MainFragmentModule;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;


@Module(includes = BaseActivityModule.class)
public abstract class MainActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragmentInjector();

    @Binds
    @ActivityScope
    abstract Activity activity(MainActivity mainActivity);


}
