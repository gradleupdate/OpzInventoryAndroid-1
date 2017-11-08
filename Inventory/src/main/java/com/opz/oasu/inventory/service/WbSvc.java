package com.opz.oasu.inventory.service;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;

import com.opz.oasu.inventory.R;
import java.io.File;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class WbSvc {

    private static final String LOGGER_TAG = WbSvc.class.getName();

    private final Application application;
    private final SharedPreferences sharedPreferences;

    private final String prefSourceFileKey;
    private final String defaultSourceFilePref;
    private final String LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START;

    @Inject
    WbSvc(Application application) {
        this.application = application;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);

        Resources resources = this.application.getResources();
        this.prefSourceFileKey = resources.getString(R.string.pref_source_file_key);
        this.defaultSourceFilePref = resources.getString(R.string.pref_default_source_file);

        LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_availability_checking_start);
    }

    public boolean wbExists() {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START);
        String sourceFilePrefValue =
                sharedPreferences.getString(prefSourceFileKey, defaultSourceFilePref);

        File sourceFile = new File(Environment.getExternalStorageDirectory(), sourceFilePrefValue);
        return sourceFile.exists();
    }
}
