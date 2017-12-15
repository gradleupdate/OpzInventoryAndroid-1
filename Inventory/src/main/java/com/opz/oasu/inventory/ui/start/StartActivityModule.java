package com.opz.oasu.inventory.ui.start;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ContributesAndroidInjector;

import com.opz.oasu.inventory.di.ActivityScope;
import com.opz.oasu.inventory.di.FragmentScope;
import com.opz.oasu.inventory.ui.common.BaseActivityModule;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsFragment;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsFragmentModule;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragment;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragmentActionListener;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragmentModule;


@Module(includes = BaseActivityModule.class)
public abstract class StartActivityModule {

    @FragmentScope
    @ContributesAndroidInjector(modules = StartFragmentModule.class)
    abstract StartFragment startFragmentInjector();

    @FragmentScope
    @ContributesAndroidInjector(modules = DetailsFragmentModule.class)
    abstract DetailsFragment mainFragmentInjector();

    @Binds
    @ActivityScope
    abstract Activity activity(StartActivity startActivity);

    @Binds
    @ActivityScope
    abstract StartFragmentActionListener startFragmentActionListener(StartActivity startActivity);
}
