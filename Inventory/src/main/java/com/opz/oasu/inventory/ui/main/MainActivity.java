package com.opz.oasu.inventory.ui.main;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toolbar;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.navigation.Navigator;
import com.opz.oasu.inventory.ui.common.BaseActivity;
import com.opz.oasu.inventory.ui.main.fragment.view.MainFragment;

import javax.annotation.Nullable;
import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MainActivity extends BaseActivity {

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
            addFragment(R.id.common_fragment_container, new MainFragment());
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem mainMenuItem = menu.findItem(R.id.main_menu_navigation_group_main);
        mainMenuItem.setEnabled(false);
        mainMenuItem.setVisible(false);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int id = menuItem.getItemId();
        switch (id) {
            case R.id.main_menu_navigation_group_settings: {
                navigator.startSettingsActivity(MainActivity.this);
                break;
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
