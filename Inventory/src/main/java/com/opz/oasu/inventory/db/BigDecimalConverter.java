package com.opz.oasu.inventory.db;

import android.arch.persistence.room.TypeConverter;

import java.math.BigDecimal;


public final class BigDecimalConverter {

    private static final int NUMBER_OF_FRACTIONS = 2;

    @TypeConverter
    public static int toInt(BigDecimal value) {
        return value.scaleByPowerOfTen(NUMBER_OF_FRACTIONS).intValue();
    }

    @TypeConverter
    public static BigDecimal fromInt(int value) {
        return new BigDecimal(value).scaleByPowerOfTen(-NUMBER_OF_FRACTIONS);
    }

}
