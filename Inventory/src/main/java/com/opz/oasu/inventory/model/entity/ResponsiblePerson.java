package com.opz.oasu.inventory.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;

import static com.opz.oasu.inventory.model.entity.ResponsiblePerson.ID_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.ResponsiblePerson.NAME_COLUMN_NAME;
import static com.opz.oasu.inventory.model.entity.ResponsiblePerson.RESPONSIBLE_PERSON_TABLE_NAME;


@Entity(tableName = RESPONSIBLE_PERSON_TABLE_NAME,
        indices = {
                @Index(value = {ID_COLUMN_NAME, NAME_COLUMN_NAME})})
public class ResponsiblePerson {

    public static final String RESPONSIBLE_PERSON_TABLE_NAME    = "responsible_person";
    public static final String IS_VALID_COLUMN_NAME             = "is_valid";

    static final String ID_COLUMN_NAME                          = "id";
    static final String NAME_COLUMN_NAME                        = "name";

    private static final String TABLE_NUMBER_COLUMN_NAME        = "table_number";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID_COLUMN_NAME)
    private long id;

    @ColumnInfo(name = NAME_COLUMN_NAME)
    public String name;

    @ColumnInfo(name = TABLE_NUMBER_COLUMN_NAME)
    private long tableNumber;

    @ColumnInfo(name = IS_VALID_COLUMN_NAME)
    private boolean valid;

    public ResponsiblePerson() { // JPA only

    }

    public long getId() {
        return id;
    }

    // see responding comment in Nomenclature entity
    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getTableNumber() {
        return tableNumber;
    }

    public void setTableNumber(long tableNumber) {
        this.tableNumber = tableNumber;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResponsiblePerson that = (ResponsiblePerson) o;
        return getTableNumber() == that.getTableNumber() &&
                isValid() == that.isValid() &&
                Objects.equals(getName(), that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getTableNumber(), isValid());
    }
}
