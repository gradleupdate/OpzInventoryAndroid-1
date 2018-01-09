package com.opz.oasu.inventory.ui.details.fragment.presenter;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.opz.oasu.inventory.IntentRequestCodes;
import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.model.entity.Nomenclature;
import com.opz.oasu.inventory.service.WbSvc;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.details.fragment.view.DetailsView;

import java.io.File;
import java.util.List;

import javax.inject.Inject;


public final class DetailsPresenterImpl extends BasePresenter<DetailsView> implements DetailsPresenter {

    private static final String LOGGER_TAG = DetailsPresenterImpl.class.getName();

    private final String LOGGER_INVALID_REQUEST_CODE;
    private final String LOGGER_INVALID_RESULT_CODE;
    private final String LOGGER_EMPTY_RESULT;

    private final Activity activity;

    private final WbSvc wbSvc;

    @Inject
    DetailsPresenterImpl(
            DetailsView view,
            Activity activity,
            WbSvc wbSvc) {
        super(view);
        this.activity = activity;
        this.wbSvc = wbSvc;

        Resources resources = activity.getResources();
        this.LOGGER_INVALID_REQUEST_CODE = resources.getString(R.string.logger_fragment_details_invalid_request_code);
        this.LOGGER_INVALID_RESULT_CODE = resources.getString(R.string.logger_fragment_details_invalid_result_code);
        this.LOGGER_EMPTY_RESULT = activity.getResources().getString(R.string.logger_fragment_details_empty_result);
    }

    @Override
    public void onFragmentStart() {

    }

    @Override
    public void processActivityResult(IntentRequestCodes requestCode, int resultCode, Intent resultData) {
        switch (requestCode) {
            case SOURCE_SPREADSHEET_FILE_SELECT_REQUEST_CODE: {
                switch (resultCode) {
                    case Activity.RESULT_OK: {
                        Uri result = resultData.getData();
                        if (result != null) {
                            final String filePath = result.getPath().split(":")[1];
                            final ProgressBar addInventoryDataProgressBar = activity.findViewById(R.id.fragment_details_adding_data_progressBar);
                            AsyncTask.execute(new Runnable() {
                                @Override
                                public void run() {
                                    addInventoryData(filePath, addInventoryDataProgressBar);
                                }
                            });
                        } else
                            Log.d(LOGGER_TAG, LOGGER_EMPTY_RESULT);
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

    private void addInventoryData(String filePath, final ProgressBar progressBar) {
        final File wbFile = new File(Environment.getExternalStorageDirectory(), filePath);
        if (wbSvc.wbExists(wbFile)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.VISIBLE);
                }
            });
            List<Nomenclature> nomenclatures = wbSvc.readWb(wbFile, progressBar);
            Log.d(LOGGER_TAG, nomenclatures.toString());
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    progressBar.setVisibility(View.INVISIBLE);
                    progressBar.setProgress(0);
                }
            });

            // TODO: solve issue with Room index on entities link

            // TODO: save data to local DB
        } else {
            Log.d(LOGGER_TAG, "File not exists.");
        }
    }
}
