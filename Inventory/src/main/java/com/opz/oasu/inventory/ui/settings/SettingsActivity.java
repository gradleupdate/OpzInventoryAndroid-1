package com.opz.oasu.inventory.ui.settings;

import android.app.ActionBar;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toolbar;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.navigation.Navigator;
import com.opz.oasu.inventory.ui.common.BaseActivity;
import com.opz.oasu.inventory.ui.settings.fragment.view.SettingsFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SettingsActivity extends BaseActivity {

    @Inject
    Navigator navigator;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_common);
        ButterKnife.bind(this);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        setActionBar(toolbar);
        ActionBar actionBar = getActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        if (savedInstanceState == null) {
            addFragment(R.id.common_fragment_container, new SettingsFragment());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem settingsMenuItem = menu.findItem(R.id.main_menu_navigation_group_settings);
        settingsMenuItem.setVisible(false);
        settingsMenuItem.setEnabled(false);
        return super.onCreateOptionsMenu(menu);
    }
}
