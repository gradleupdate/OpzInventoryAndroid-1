package com.opz.oasu.inventory.ui.common.view.fragment.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.opz.oasu.inventory.ui.common.view.MVPView;


public abstract class BasePresenter<T extends MVPView> implements Presenter {

    protected final T view;

    protected BasePresenter(T view) {
        this.view = view;
    }

    @Override
    public void onStart(@Nullable Bundle savedInstanceState) {
    }

    @Override
    public void onResume() {
    }

    @Override
    public void onPause() {
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
    }

    @Override
    public void onEnd() {
    }
}