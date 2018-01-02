package com.opz.oasu.inventory.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import com.opz.oasu.inventory.model.dao.NomenclatureDao;
import com.opz.oasu.inventory.model.dao.ResponsiblePersonDao;
import com.opz.oasu.inventory.model.entity.Nomenclature;
import com.opz.oasu.inventory.model.entity.ResponsiblePerson;


@Database(entities = {Nomenclature.class, ResponsiblePerson.class}, version = 1, exportSchema = false)
@TypeConverters({DateConverter.class, BooleanConverter.class, BigDecimalConverter.class})
public abstract class Db extends RoomDatabase {
    public abstract NomenclatureDao nomenclatureDao();
    public abstract ResponsiblePersonDao responsiblePersonDao();
}
