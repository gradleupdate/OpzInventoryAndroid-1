package com.opz.oasu.inventory.ui.main.fragment.presenter;

import android.content.Context;

import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.main.fragment.view.MainView;

import javax.inject.Inject;


public final class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {

    private static final String LOGGER_TAG = MainPresenterImpl.class.getName();

    private final Context context;

    @Inject
    MainPresenterImpl(
            MainView view,
            Context context) {
        super(view);
        this.context = context;
    }

    @Override
    public void onFragmentStart() {

    }
}
