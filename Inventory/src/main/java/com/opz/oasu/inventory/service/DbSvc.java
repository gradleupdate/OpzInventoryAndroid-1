package com.opz.oasu.inventory.service;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.opz.oasu.inventory.db.Db;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public final class DbSvc {

    private final Application application;

    @Inject
    DbSvc(Application application) {
        this.application = application;
    }

    public void createNewInventoryRoom(String dbName) {
        Room.databaseBuilder(application.getApplicationContext(), Db.class, dbName).build();
    }
}
