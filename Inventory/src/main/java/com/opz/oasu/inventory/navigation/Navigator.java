package com.opz.oasu.inventory.navigation;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;

import com.opz.oasu.inventory.ui.main.MainActivity;
import com.opz.oasu.inventory.ui.settings.SettingsActivity;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class Navigator {

    @Inject
    Navigator() {}

    public void startMainActivity(final Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        context.startActivity(intent);
    }

    public void startSettingsActivity(final Context context) {
        Intent intent = new Intent(context, SettingsActivity.class);
        context.startActivity(intent);
    }
}
