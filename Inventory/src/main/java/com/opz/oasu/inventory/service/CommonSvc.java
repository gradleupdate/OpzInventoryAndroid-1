package com.opz.oasu.inventory.service;

import android.app.Application;
import android.os.Environment;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public final class CommonSvc {

    public final static int EXT_STORAGE_READ_WRITE_AVAILABLE = 1;
    public final static int EXT_STORAGE_READ_ONLY_AVAILABLE = 2;
    public final static int EXT_STORAGE_UNAVAILABLE = 3;

    private final Application application;

    @Inject
    public CommonSvc(Application application) {
        this.application = application;
    }

    public int checkExternalStorageAvailability() {
        String state = Environment.getExternalStorageState();
        switch (state) {
            case Environment.MEDIA_MOUNTED: {
                return EXT_STORAGE_READ_WRITE_AVAILABLE;
            }
            case Environment.MEDIA_MOUNTED_READ_ONLY: {
                return EXT_STORAGE_READ_ONLY_AVAILABLE;
            }
            default: {
                return EXT_STORAGE_UNAVAILABLE;
            }
        }
    }

}
