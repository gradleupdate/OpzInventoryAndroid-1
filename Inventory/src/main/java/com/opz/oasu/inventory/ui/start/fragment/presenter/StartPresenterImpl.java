package com.opz.oasu.inventory.ui.start.fragment.presenter;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import javax.inject.Inject;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.service.DbSvc;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.start.fragment.view.StartView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public final class StartPresenterImpl extends BasePresenter<StartView> implements StartPresenter {

    private static final String LOGGER_TAG = StartPresenterImpl.class.getName();

    private final String LOGGER_START_CREATING_NEW_INVENTORY;
    private final String LOGGER_FINISH_CREATING_NEW_INVENTORY;

    private final DbSvc dbSvc;

    @Inject
    StartPresenterImpl(
            StartView view,
            Context context,
            DbSvc dbSvc) {
        super(view);
        final Resources resources = context.getResources();
        this.LOGGER_START_CREATING_NEW_INVENTORY = resources.getString(R.string.logger_fragment_start_start_creating_new_inventory);
        this.LOGGER_FINISH_CREATING_NEW_INVENTORY = resources.getString(R.string.logger_fragment_start_finish_creating_new_inventory);

        this.dbSvc = dbSvc;
    }

    public void createNewInventory() {
        Log.d(LOGGER_TAG, LOGGER_START_CREATING_NEW_INVENTORY);

        final Calendar currentCalendar = Calendar.getInstance();
        final SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd_HH_mm_ss_SSS",
                Locale.getDefault());

        final String dbName = dateFormat.format(currentCalendar.getTime()) + ".sqlite3";
        dbSvc.createNewInventoryRoom(dbName);

        Log.d(LOGGER_TAG, LOGGER_FINISH_CREATING_NEW_INVENTORY.replace("%1$s", dbName));

    }
}
