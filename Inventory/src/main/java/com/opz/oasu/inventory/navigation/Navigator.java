package com.opz.oasu.inventory.navigation;

import android.content.Context;
import android.content.Intent;

import com.opz.oasu.inventory.ui.settings.SettingsActivity;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Navigator {

    @Inject
    Navigator() {}

    public void startSettingsActivity(final Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
}
