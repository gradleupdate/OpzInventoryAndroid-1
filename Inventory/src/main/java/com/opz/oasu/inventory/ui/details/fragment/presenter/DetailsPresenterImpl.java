package com.opz.oasu.inventory.ui.details.fragment.presenter;

import android.content.Context;

import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsView;

import javax.inject.Inject;


public final class DetailsPresenterImpl extends BasePresenter<DetailsView> implements DetailsPresenter {

    private static final String LOGGER_TAG = DetailsPresenterImpl.class.getName();

    private final Context context;

    @Inject
    DetailsPresenterImpl(
            DetailsView view,
            Context context) {
        super(view);
        this.context = context;
    }

    @Override
    public void onFragmentStart() {

    }
}
