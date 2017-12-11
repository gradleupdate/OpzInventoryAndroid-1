package com.opz.oasu.inventory.ui.settings.fragment.presenter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.Uri;
import android.preference.Preference;
import android.preference.PreferenceManager;
import android.util.Log;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.service.DbSvc;
import com.opz.oasu.inventory.service.WbSvc;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.IntentRequestCodes;
import com.opz.oasu.inventory.ui.settings.fragment.view.SettingsFragment;

import javax.inject.Inject;


public class SettingsPresenterImpl extends BasePresenter<SettingsFragment> implements SettingsPresenter {

    @Inject
    SettingsPresenterImpl(SettingsFragment view) {
        super(view);
    }
    /*
    private static final String LOGGER_TAG = SettingsPresenterImpl.class.getName();

    private final Context context;

    private final String LOGGER_INVALID_REQUEST_CODE;
    private final String LOGGER_INVALID_RESULT_CODE;

    private final WbSvc wbSvc;

    private final DbSvc dbSvc;

    @Inject
    SettingsPresenterImpl(
            SettingsFragment view,
            WbSvc wbSvc,
            DbSvc dbSvc,
            Context context) {
        super(view);
        this.context = context;

        Resources resources = context.getResources();
        this.LOGGER_INVALID_REQUEST_CODE =
                resources.getString(R.string.logger_fragment_settings_invalid_request_code);
        this.LOGGER_INVALID_RESULT_CODE =
                resources.getString(R.string.logger_fragment_settings_invalid_result_code);

        this.wbSvc = wbSvc;
        this.dbSvc = dbSvc;
    }

    @Override
    public void onFragmentStarts() {

    }

    @Override
    public void processActivityResult(IntentRequestCodes requestCode, int resultCode, Intent resultData) {
        Log.d(
                LOGGER_TAG,
                context.getResources().getString(
                        R.string.logger_fragment_settings_start_processing_source_workbook_selection,
                        IntentRequestCodes.values()[requestCode.ordinal()],
                        resultCode,
                        resultData.toString()));
        switch (requestCode) {
            case SOURCE_SPREADSHEET_FILE_SELECT_REQUEST_CODE: {
                switch (resultCode) {
                    case Activity.RESULT_OK: {
                        Uri result = resultData.getData();
                        if (result != null) {
                            String pathToFile = result.getPath().split(":")[1];
                            SharedPreferences sharedPreferences =
                                    PreferenceManager.getDefaultSharedPreferences(context);
                            sharedPreferences
                                    .edit().putString(
                                            context.getResources().getString(R.string.pref_source_file_key),
                                            pathToFile)
                                    .apply();
                        } else Log.d(
                                LOGGER_TAG,
                                context.getResources().getString(R.string.logger_fragment_settings_empty_result));
                        break;
                    }
                    default: {
                        Log.d(LOGGER_TAG, LOGGER_INVALID_RESULT_CODE);
                    }
                }
                break;
            }
            default: {
                Log.d(LOGGER_TAG, LOGGER_INVALID_REQUEST_CODE);
            }
        }
    }
    */
}
