package com.opz.oasu.inventory.ui.details.fragment.presenter;

import android.content.Context;

import com.opz.oasu.inventory.service.WbSvc;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsView;

import javax.inject.Inject;


public final class DetailsPresenterImpl extends BasePresenter<DetailsView> implements DetailsPresenter {

    private static final String LOGGER_TAG = DetailsPresenterImpl.class.getName();

    private final Context context;

    private final WbSvc wbSvc;

    @Inject
    DetailsPresenterImpl(
            DetailsView view,
            Context context,
            WbSvc wbSvc) {
        super(view);
        this.context = context;
        this.wbSvc = wbSvc;
    }

    @Override
    public void onFragmentStart() {

    }

    @Override
    public void addInventoryData() {
        // TODO: add open file dialog from settings activity code

        // TODO: read data from provided file

        // TODO: solve issue with Room index on entities link

        // TODO: save data to local DB
    }
}
