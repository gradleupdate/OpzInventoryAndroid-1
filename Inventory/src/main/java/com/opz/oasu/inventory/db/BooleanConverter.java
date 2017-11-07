package com.opz.oasu.inventory.db;

import android.arch.persistence.room.TypeConverter;


public final class BooleanConverter {

    @TypeConverter
    public static int fromBoolean(boolean value) {
        return value ? 1 : 0;
    }

    @TypeConverter
    public static boolean fromInt(int value) {
        return value > 0;
    }

}
