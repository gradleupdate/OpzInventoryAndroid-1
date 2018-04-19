package com.opz.oasu.inventory.model.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import com.opz.oasu.inventory.model.entity.ResponsiblePerson;

import static com.opz.oasu.inventory.model.entity.ResponsiblePerson.IS_VALID_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.ResponsiblePerson.RESPONSIBLE_PERSON_TABLE_NAME;

@Dao
public interface ResponsiblePersonDao {

    @Insert
    void insertAll(List<ResponsiblePerson> responsiblePersons);

    @Query("SELECT * FROM " + RESPONSIBLE_PERSON_TABLE_NAME)
    List<ResponsiblePerson> getAll();

    @Query("SELECT * FROM " + RESPONSIBLE_PERSON_TABLE_NAME + " WHERE NAME LIKE :name")
    List<ResponsiblePerson> getByName(String name);

    @Update(onConflict = OnConflictStrategy.REPLACE)
    void update(ResponsiblePerson responsiblePerson);

    @Query("UPDATE " + RESPONSIBLE_PERSON_TABLE_NAME +" SET " + IS_VALID_COLUMN_NAME + "=0 WHERE ID=:id")
    void delete(long id);
}
