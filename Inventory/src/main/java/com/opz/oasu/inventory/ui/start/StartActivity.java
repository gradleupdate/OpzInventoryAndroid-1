package com.opz.oasu.inventory.ui.start;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.navigation.Navigator;
import com.opz.oasu.inventory.ui.common.BaseActivity;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragment;
import com.opz.oasu.inventory.ui.start.fragment.view.StartFragmentActionListener;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public final class StartActivity extends BaseActivity implements StartFragmentActionListener {

    @Inject
    Navigator navigator;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);

        setActionBar(toolbar);

        if (savedInstanceState == null) {
            addFragment(R.id.common_fragment_container, new StartFragment());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.main_menu_navigation_group_settings: {
                navigator.startSettingsActivity(StartActivity.this);
                break;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
