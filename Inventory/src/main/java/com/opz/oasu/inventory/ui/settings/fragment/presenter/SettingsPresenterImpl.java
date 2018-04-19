package com.opz.oasu.inventory.ui.settings.fragment.presenter;

import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.settings.fragment.view.SettingsFragment;

import javax.inject.Inject;

public class SettingsPresenterImpl extends BasePresenter<SettingsFragment> implements SettingsPresenter {

    @Inject
    SettingsPresenterImpl(SettingsFragment view) {
        super(view);
    }

    @Override
    public void onFragmentStarts() {

    }
}
