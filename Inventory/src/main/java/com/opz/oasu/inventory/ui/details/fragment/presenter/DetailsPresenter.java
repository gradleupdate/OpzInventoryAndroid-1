package com.opz.oasu.inventory.ui.details.fragment.presenter;

import android.content.Intent;

import com.opz.oasu.inventory.IntentRequestCodes;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.Presenter;


public interface DetailsPresenter extends Presenter {

    void onFragmentStart();

    void processActivityResult(IntentRequestCodes requestCode, int resultCode, Intent resultData);
}
