package com.opz.oasu.inventory.db;

import android.arch.persistence.room.TypeConverter;
import android.support.annotation.Nullable;

import java.util.Date;


public final class DateConverter {

    @Nullable
    @TypeConverter
    public static Date fromTimestamp(long value) {
        return value == 0 ? null : new Date(value);
    }

    @TypeConverter
    public static long toTimestamp(Date date) {
        return date == null ? 0 : date.getTime();
    }
}
