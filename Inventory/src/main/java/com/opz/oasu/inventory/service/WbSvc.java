package com.opz.oasu.inventory.service;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class WbSvc {

    private final Application application;

    @Inject
    public WbSvc(Application application) {
        this.application = application;
    }

    public boolean wbExists() {
        return false;
    }
}
