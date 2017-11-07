package com.opz.oasu.inventory.ui.common;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;

import javax.inject.Named;

import dagger.Binds;
import dagger.Module;
import dagger.Provides;
import com.opz.oasu.inventory.di.ActivityScope;


@Module
public abstract class BaseActivityModule {

    static final String ACTIVITY_FRAGMENT_MANAGER = "BaseActivityModule.activityFragmentManager";

    @Binds
    @ActivityScope
    abstract Context activityContext(Activity activity);

    @Provides
    @Named(ACTIVITY_FRAGMENT_MANAGER)
    @ActivityScope
    static FragmentManager activityFragmentManager(Activity activity) {
        return activity.getFragmentManager();
    }
}