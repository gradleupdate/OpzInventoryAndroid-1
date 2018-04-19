package com.opz.oasu.inventory.ui.start.fragment.presenter;

import dagger.Binds;
import dagger.Module;
import com.opz.oasu.inventory.di.FragmentScope;

@Module
public abstract class StartPresenterModule {

    @Binds
    @FragmentScope
    abstract StartPresenter startPresenter(StartPresenterImpl startPresenterImpl);
}
