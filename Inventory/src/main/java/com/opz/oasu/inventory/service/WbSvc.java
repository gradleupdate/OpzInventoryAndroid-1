package com.opz.oasu.inventory.service;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.util.Log;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.model.entity.Nomenclature;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class WbSvc {

    private static final String LOGGER_TAG = WbSvc.class.getName();

    private static final String MAIN_SHEET_NAME = "Лист1";

    private final Application application;

    private final SharedPreferences sharedPreferences;

    private final String LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START;
    private final String LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START;

    @Inject
    WbSvc(Application application) {
        this.application = application;
        this.sharedPreferences = PreferenceManager.getDefaultSharedPreferences(application);

        Resources resources = this.application.getResources();

        this.LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_availability_checking_start);
        this.LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_validity_checking_start);
    }

    public boolean wbExists(String filePath) {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START);
        final File sourceFile = new File(Environment.getExternalStorageDirectory(), filePath);
        return sourceFile.exists();
    }

    public @Nullable List<Nomenclature> readWb(File wbFile) {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START);

        String filePath = wbFile.getPath();
        final String sourceFileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
        try {
            List<Nomenclature> result = new ArrayList<>();
            switch (sourceFileExtension) {
                case "xls": {
                    HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(wbFile));
                    HSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
                    int lastRowNum = mainSheet.getLastRowNum();
                    for (int i = 1; i <= lastRowNum; i++) {
                        HSSFRow row = mainSheet.getRow(i);
                        Log.i(LOGGER_TAG,
                                "Read data from row " + i + ":\n" +
                                "\tbarcode: "                           + row.getCell(0)    .getStringCellValue()   + ";\n" +
                                "\tSAP number: "                        + row.getCell(1)    .getStringCellValue()   + ";\n" +
                                "\tsubnumber: "                         + row.getCell(2)    .getStringCellValue()   + ";\n" +
                                "\tclass: "                             + row.getCell(3)    .getStringCellValue()   + ";\n" +
                                "\tname: "                              + row.getCell(4)    .getStringCellValue()   + ";\n" +
                                "\tintroduction date: "                 + row.getCell(5)    .getStringCellValue()   + ";\n" +
                                "\td introduction date: "               + row.getCell(6)    .getStringCellValue()   + ";\n" +
                                "\tserial number: "                     + row.getCell(7)    .getStringCellValue()   + ";\n" +
                                "\tinventory number: "                  + row.getCell(8)    .getStringCellValue()   + ";\n" +
                                "\tis marked: "                         + row.getCell(9)    .getNumericCellValue()  + ";\n" +
                                "\tdepartment number: "                 + row.getCell(10)   .getNumericCellValue()  + ";\n" +
                                "\tdepartment name: "                   + row.getCell(11)   .getStringCellValue()   + ";\n" +
                                "\tplan count: "                        + row.getCell(12)   .getNumericCellValue()  + ";\n" +
                                "\tobjects count: "                     + row.getCell(13)   .getNumericCellValue()  + ";\n" +
                                "\tis new: "                            + row.getCell(14)   .getNumericCellValue()  + ";\n" +
                                "\tis deleted: "                        + row.getCell(15)   .getNumericCellValue()  + ";\n" +
                                "\ttype label: "                        + row.getCell(16)   .getStringCellValue()   + ";\n" +
                                "\tinitial cost: "                      + row.getCell(17)   .getStringCellValue()   + ";\n" +
                                "\tleast cost: "                        + row.getCell(18)   .getStringCellValue()   + ";\n" +
                                "\tresponsible person name: "           + row.getCell(19)   .getStringCellValue()   + ";\n" +
                                "\tresponsible person table number: "   + row.getCell(20)   .getStringCellValue()   + ";\n" +
                                "\tlocation: "                          + row.getCell(21)   .getStringCellValue()   + ".\n");
                    }
                }
                case "xlsx": {
                    XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(wbFile));
                    XSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
                    int lastRowNum = mainSheet.getLastRowNum();
                    for (int i = 1; i <= lastRowNum; i++) {
                        XSSFRow row = mainSheet.getRow(i);
                        Log.i(LOGGER_TAG,
                                "Read data from row " + i + ":\n" +
                                "\tbarcode: "                           + row.getCell(0)    .getStringCellValue()   + ";\n" +
                                "\tSAP number: "                        + row.getCell(1)    .getStringCellValue()   + ";\n" +
                                "\tsubnumber: "                         + row.getCell(2)    .getStringCellValue()   + ";\n" +
                                "\tclass: "                             + row.getCell(3)    .getStringCellValue()   + ";\n" +
                                "\tname: "                              + row.getCell(4)    .getStringCellValue()   + ";\n" +
                                "\tintroduction date: "                 + row.getCell(5)    .getStringCellValue()   + ";\n" +
                                "\td introduction date: "               + row.getCell(6)    .getStringCellValue()   + ";\n" +
                                "\tserial number: "                     + row.getCell(7)    .getStringCellValue()   + ";\n" +
                                "\tinventory number: "                  + row.getCell(8)    .getStringCellValue()   + ";\n" +
                                "\tis marked: "                         + row.getCell(9)    .getNumericCellValue()  + ";\n" +
                                "\tdepartment number: "                 + row.getCell(10)   .getNumericCellValue()  + ";\n" +
                                "\tdepartment name: "                   + row.getCell(11)   .getStringCellValue()   + ";\n" +
                                "\tplan count: "                        + row.getCell(12)   .getNumericCellValue()  + ";\n" +
                                "\tobjects count: "                     + row.getCell(13)   .getNumericCellValue()  + ";\n" +
                                "\tis new: "                            + row.getCell(14)   .getNumericCellValue()  + ";\n" +
                                "\tis deleted: "                        + row.getCell(15)   .getNumericCellValue()  + ";\n" +
                                "\ttype label: "                        + row.getCell(16)   .getStringCellValue()   + ";\n" +
                                "\tinitial cost: "                      + row.getCell(17)   .getStringCellValue()   + ";\n" +
                                "\tleast cost: "                        + row.getCell(18)   .getStringCellValue()   + ";\n" +
                                "\tresponsible person name: "           + row.getCell(19)   .getStringCellValue()   + ";\n" +
                                "\tresponsible person table number: "   + row.getCell(20)   .getStringCellValue()   + ";\n" +
                                "\tlocation: "                          + row.getCell(21)   .getStringCellValue()   + ";\n");
                    }
                }
                default: {

                }
            }
            return result;
        } catch (IOException ioe) {
            Log.e(LOGGER_TAG, null, ioe);
            return null;
        }
    }
}
