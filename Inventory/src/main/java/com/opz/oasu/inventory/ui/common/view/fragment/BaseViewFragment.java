package com.opz.oasu.inventory.ui.common.view.fragment;

import android.os.Bundle;
import android.support.annotation.CallSuper;

import javax.inject.Inject;

import com.opz.oasu.inventory.ui.common.view.fragment.presenter.Presenter;
import com.opz.oasu.inventory.ui.common.view.MVPView;

public abstract class BaseViewFragment<T extends Presenter> extends BaseFragment
        implements MVPView {

    @Inject
    protected T presenter;

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
        presenter.onStart(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.onPause();
    }

    @CallSuper
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        presenter.onSaveInstanceState(outState);
    }

    @Override
    public void onDestroyView() {
        presenter.onEnd();
        super.onDestroyView();
    }
}