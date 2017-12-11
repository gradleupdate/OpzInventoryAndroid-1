package com.opz.oasu.inventory.ui.start.fragment.presenter;

import javax.inject.Inject;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.start.fragment.view.StartView;

public final class StartPresenterImpl extends BasePresenter<StartView> implements StartPresenter {

    @Inject
    StartPresenterImpl(StartView view) {
        super(view);
    }

}
