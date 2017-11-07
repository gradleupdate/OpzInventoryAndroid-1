package com.opz.oasu.inventory.ui.common.view.fragment.presenter;

import android.os.Bundle;
import android.support.annotation.Nullable;


public interface Presenter {

    void onStart(@Nullable Bundle savedInstanceState);

    void onResume();

    void onPause();

    void onSaveInstanceState(Bundle outState);

    void onEnd();
}