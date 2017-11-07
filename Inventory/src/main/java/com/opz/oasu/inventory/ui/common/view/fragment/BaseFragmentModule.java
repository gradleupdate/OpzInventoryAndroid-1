package com.opz.oasu.inventory.ui.common.view.fragment;

import android.app.Fragment;
import android.app.FragmentManager;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

import com.opz.oasu.inventory.di.FragmentScope;


@Module
public abstract class BaseFragmentModule {

    public static final String FRAGMENT = "BaseFragmentModule.fragment";

    static final String CHILD_FRAGMENT_MANAGER = "BaseFragmentModule.childFragmentManager";

    @Provides
    @Named(CHILD_FRAGMENT_MANAGER)
    @FragmentScope
    static FragmentManager childFragmentManager(@Named(FRAGMENT) Fragment fragment) {
        return fragment.getChildFragmentManager();
    }
}