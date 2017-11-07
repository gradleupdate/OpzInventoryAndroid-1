package com.opz.oasu.inventory.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.navigation.Navigator;
import com.opz.oasu.inventory.ui.common.BaseActivity;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragment;

import javax.inject.Inject;


public final class StartActivity extends BaseActivity {

    @Inject
    Navigator navigator;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullscreen);

        if (savedInstanceState == null) {
            addFragment(R.id.fullscreen_fragment_container, new StartFragment());
        }

        navigator.startMainActivity(StartActivity.this);
    }
}
