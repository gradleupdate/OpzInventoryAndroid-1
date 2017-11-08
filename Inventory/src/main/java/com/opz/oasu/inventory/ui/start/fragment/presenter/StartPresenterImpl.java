package com.opz.oasu.inventory.ui.start.fragment.presenter;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import javax.inject.Inject;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.db.Db;
import com.opz.oasu.inventory.service.CommonSvc;
import com.opz.oasu.inventory.service.DbSvc;
import com.opz.oasu.inventory.service.WbSvc;
import com.opz.oasu.inventory.ui.common.view.fragment.presenter.BasePresenter;
import com.opz.oasu.inventory.ui.start.fragment.view.StartView;

import static com.opz.oasu.inventory.service.CommonSvc.EXT_STORAGE_READ_ONLY_AVAILABLE;
import static com.opz.oasu.inventory.service.CommonSvc.EXT_STORAGE_READ_WRITE_AVAILABLE;
import static com.opz.oasu.inventory.service.CommonSvc.EXT_STORAGE_UNAVAILABLE;


public final class StartPresenterImpl extends BasePresenter<StartView> implements StartPresenter {

    private static final String LOGGER_TAG = StartPresenterImpl.class.getName();

    private final Context context;

    private final String LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START;
    private final String LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE;
    private final String LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY;
    private final String LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_UNAVAILABLE;

    private final String LOGGER_SOURCE_WORKBOOK_CHECKING_START;
    private final String LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS;
    private final String LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS;

    private final String TEXTVIEW_COMMON_CHECK_PASSED;

    private final String TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START;
    private final String TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE;
    private final String TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY;
    private final String TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_UNAVAILABLE;

    private final String TEXTVIEW_SOURCE_WORKBOOK_CHECKING_START;
    private final String TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START;
    private final String TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS;
    private final String TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS;

    private final CommonSvc commonSvc;
    private final DbSvc dbSvc;
    private final WbSvc wbSvc;

    @Inject
    StartPresenterImpl(
            StartView view,
            CommonSvc commonSvc,
            DbSvc dbSvc,
            WbSvc wbSvc,
            Context context) {
        super(view);
        this.context = context;
        Resources resources = this.context.getResources();

        this.LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START =
                resources.getString(R.string.logger_fragment_start_external_storage_availability_checking_start);
        this.LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE =
                resources.getString(R.string.logger_fragment_start_external_storage_availability_checking_result_read_write);
        this.LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY =
                resources.getString(R.string.logger_fragment_start_external_storage_availability_checking_result_read_only);
        this.LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_UNAVAILABLE =
                resources.getString(R.string.logger_fragment_start_external_storage_availability_checking_unavailable);

        this.LOGGER_SOURCE_WORKBOOK_CHECKING_START =
                resources.getString(R.string.logger_fragment_start_source_workbook_checking_start);
        /*this.LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_availability_checking_start);*/
        this.LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS =
                resources.getString(R.string.logger_fragment_start_source_workbook_checking_workbook_exists);
        this.LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS =
                resources.getString(R.string.logger_fragment_start_source_workbook_checking_workbook_does_not_exist);

        this.TEXTVIEW_COMMON_CHECK_PASSED =
                resources.getString(R.string.textview_common_check_passed);
        this.TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START =
                resources.getString(R.string.textview_fragment_start_external_storage_availability_checking_start);
        this.TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE =
                resources.getString(R.string.textview_fragment_start_external_storage_availability_checking_result_read_write);
        this.TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY =
                resources.getString(R.string.textview_fragment_start_external_storage_availability_checking_result_read_only);
        this.TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_UNAVAILABLE =
                resources.getString(R.string.textview_fragment_start_external_storage_availability_checking_result_unavailable);

        this.TEXTVIEW_SOURCE_WORKBOOK_CHECKING_START =
                resources.getString(R.string.textview_fragment_start_source_workbook_checking_start);
        this.TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START =
                resources.getString(R.string.textview_fragment_start_source_workbook_existence_checking_start);
        this.TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS =
                resources.getString(R.string.textview_fragment_start_source_workbook_exists);
        this.TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS =
                resources.getString(R.string.textview_fragment_start_source_workbook_does_not_exist);

        this.commonSvc = commonSvc;
        this.dbSvc = dbSvc;
        this.wbSvc = wbSvc;
    }

    @Override
    public void onFragmentStart() {
        Log.i(LOGGER_TAG, LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START);
        view.addProgressMessage(TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_START);
        switch (commonSvc.checkExternalStorageAvailability()) {
            case EXT_STORAGE_READ_WRITE_AVAILABLE: {
                Log.i(LOGGER_TAG, LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE);
                view.addProgressMessage(TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_WRITE);
                break;
            }
            case EXT_STORAGE_READ_ONLY_AVAILABLE: {
                Log.i(LOGGER_TAG, LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY);
                view.addProgressMessage(TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_READ_ONLY);
                return;
            }
            case EXT_STORAGE_UNAVAILABLE: {
                Log.i(LOGGER_TAG, LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_UNAVAILABLE);
                view.addProgressMessage(TEXTVIEW_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_RESULT_UNAVAILABLE);
                return;
            }
            default: {
                Log.i(LOGGER_TAG, LOGGER_EXTERNAL_STORAGE_AVAILABILITY_CHECKING_UNAVAILABLE);
            }
        }

        Log.i(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_CHECKING_START);
        view.addProgressMessage(TEXTVIEW_SOURCE_WORKBOOK_CHECKING_START);

        checkWorkbook();

        Room.inMemoryDatabaseBuilder(context.getApplicationContext(), Db.class).build();
    }

    private void checkWorkbook() {
        view.addProgressMessage(TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START);
        if(wbSvc.wbExists()) {
            Log.i(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS);
            view.addProgressMessage(TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_EXISTS);
        }
        else {
            Log.i(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS);
            view.addProgressMessage(TEXTVIEW_SOURCE_WORKBOOK_EXISTENCE_CHECKING_RESULT_DOES_NOT_EXISTS);
        }
    }
}
