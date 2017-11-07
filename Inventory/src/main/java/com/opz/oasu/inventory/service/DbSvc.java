package com.opz.oasu.inventory.service;

import android.app.Application;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public final class DbSvc {

    private final Application application;

    @Inject
    public DbSvc(Application application) {
        this.application = application;
    }
}
