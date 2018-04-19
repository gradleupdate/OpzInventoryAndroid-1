package com.opz.oasu.inventory.service;

import android.os.Handler;
import android.app.Application;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import com.opz.oasu.inventory.R;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
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
public final class WbSvc {

    private static final String LOGGER_TAG = WbSvc.class.getName();

    private static final String MAIN_SHEET_NAME = "Лист1";

    private enum CELL_NUMBERS {
        BARCODE,
        SAP_NUMBER,
        SUB_NUMBER,
        CLASS,
        DESCRIPTION,
        INTRODUCTION_DATE,
        SERIAL_NUMBER,
        INVENTORY_NUMBER,
        IS_MARKED,
        DEPARTMENT_NUMBER,
        DEPARTMENT_DESCRIPTION,
        PLAN_COUNT,
        OBJECTS_COUNT,
        IS_NEW,
        IS_DELETED,
        TYPE_LABEL,
        INITIAL_COST,
        LEAST_COST,
        RESPONSIBLE_PERSON_NAME,
        RESPONSIBLE_PERSON_TABLE_NUMBER,
        LOCATION
    }

    private final String LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START;
    private final String LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START;

    @Inject
    WbSvc(Application application) {
        Resources resources = application.getResources();

        this.LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_availability_checking_start);
        this.LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START =
                resources.getString(R.string.logger_workbook_service_source_workbook_checking_validity_checking_start);
    }

    public boolean wbExists(File wbFile) {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_EXISTENCE_CHECKING_START);
        return wbFile.exists();
    }

    public List<ParsedRowStruct> readWb(File wbFile, ProgressBar progressBar) {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START);

        final String filePath = wbFile.getPath();
        final String sourceFileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
        List<ParsedRowStruct> readingResult;
        try {
            switch (sourceFileExtension) {
                case "xls": {
                    readingResult = readXls(wbFile, progressBar);
                    break;
                }
                case "xlsx": {
                    readingResult = readXlsx(wbFile, progressBar);
                    break;
                }
                default: {
                    readingResult = new ArrayList<>();
                }
            }
        } catch (IOException ioe) {
            Log.e(LOGGER_TAG, null, ioe);
            return null;
        }
        return readingResult;
    }

    private List<ParsedRowStruct> readXls(File wbFile, final ProgressBar progressBar) throws IOException {
        List<ParsedRowStruct> readingResult = new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(wbFile));
        HSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
        Handler progressBarHandler = new Handler(Looper.getMainLooper());
        int lastRowNum = mainSheet.getLastRowNum();
        progressBar.setMax(lastRowNum);
        for (int i = 1; i <= lastRowNum; i++) {
            HSSFRow row = mainSheet.getRow(i);
            readingResult.add(parseRow(row));
            final int progressStatus = i;
            progressBarHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progressStatus);
                }
            });
        }
        workbook.close();
        return readingResult;
    }

    private List<ParsedRowStruct> readXlsx(File wbFile, final ProgressBar progressBar) throws IOException {
        List<ParsedRowStruct> readingResult = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(wbFile));
        XSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
        Handler progressBarHandler = new Handler(Looper.getMainLooper());
        int lastRowNum = mainSheet.getLastRowNum();
        progressBar.setMax(lastRowNum);
        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = mainSheet.getRow(i);
            readingResult.add(parseRow(row));
            final int progressStatus = i;
            progressBarHandler.post(new Runnable() {
                @Override
                public void run() {
                    progressBar.setProgress(progressStatus);
                }
            });
        }
        workbook.close();
        return readingResult;
    }
    /*
    private void logWbRow(Row row) {
        Log.i(LOGGER_TAG,
                "Read data from row " + row.getRowNum() + ":\n" +
                        "\tbarcode: "                           + row.getCell(CELL_NUMBERS.BARCODE.ordinal())                             .getStringCellValue()   + ";\n" +
                        "\tSAP number: "                        + row.getCell(CELL_NUMBERS.SAP_NUMBER.ordinal())                          .getStringCellValue()   + ";\n" +
                        "\tsubnumber: "                         + row.getCell(CELL_NUMBERS.SUB_NUMBER.ordinal())                          .getStringCellValue()   + ";\n" +
                        "\tclass: "                             + row.getCell(CELL_NUMBERS.CLASS.ordinal())                               .getStringCellValue()   + ";\n" +
                        "\tdescription: "                       + row.getCell(CELL_NUMBERS.DESCRIPTION.ordinal())                         .getStringCellValue()   + ";\n" +
                        "\tintroduction date: "                 + row.getCell(CELL_NUMBERS.INTRODUCTION_DATE.ordinal())                   .getStringCellValue()   + ";\n" +
                        "\tserial number: "                     + row.getCell(CELL_NUMBERS.SERIAL_NUMBER.ordinal())                       .getStringCellValue()   + ";\n" +
                        "\tinventory number: "                  + row.getCell(CELL_NUMBERS.INVENTORY_NUMBER.ordinal())                    .getStringCellValue()   + ";\n" +
                        "\tis marked: "                         + row.getCell(CELL_NUMBERS.IS_MARKED.ordinal())                           .getNumericCellValue()  + ";\n" +
                        "\tdepartment number: "                 + row.getCell(CELL_NUMBERS.DEPARTMENT_NUMBER.ordinal())                   .getStringCellValue()   + ";\n" +
                        "\tdepartment description: "            + row.getCell(CELL_NUMBERS.DEPARTMENT_DESCRIPTION.ordinal())              .getStringCellValue()   + ";\n" +
                        "\tplan count: "                        + row.getCell(CELL_NUMBERS.PLAN_COUNT.ordinal())                          .getNumericCellValue()  + ";\n" +
                        "\tobjects count: "                     + row.getCell(CELL_NUMBERS.OBJECTS_COUNT.ordinal())                       .getNumericCellValue()  + ";\n" +
                        "\tis new: "                            + row.getCell(CELL_NUMBERS.IS_NEW.ordinal())                              .getNumericCellValue()  + ";\n" +
                        "\tis deleted: "                        + row.getCell(CELL_NUMBERS.IS_DELETED.ordinal())                          .getNumericCellValue()  + ";\n" +
                        "\ttype label: "                        + row.getCell(CELL_NUMBERS.TYPE_LABEL.ordinal())                          .getStringCellValue()   + ";\n" +
                        "\tinitial cost: "                      + row.getCell(CELL_NUMBERS.INITIAL_COST.ordinal())                        .getNumericCellValue()  + ";\n" +
                        "\tleast cost: "                        + row.getCell(CELL_NUMBERS.LEAST_COST.ordinal())                          .getNumericCellValue()  + ";\n" +
                        "\tresponsible person name: "           + row.getCell(CELL_NUMBERS.RESPONSIBLE_PERSON_NAME.ordinal())             .getStringCellValue()   + ";\n" +
                        "\tresponsible person table number: "   + row.getCell(CELL_NUMBERS.RESPONSIBLE_PERSON_TABLE_NUMBER.ordinal())     .getNumericCellValue()  + ";\n" +
                        "\tlocation: "                          + row.getCell(CELL_NUMBERS.LOCATION.ordinal())                            .getStringCellValue()   + ".\n");
    }
    */
    private ParsedRowStruct parseRow(Row row) {
        final String barcode = row.getCell(CELL_NUMBERS.BARCODE.ordinal()).getStringCellValue();
        final String sapNumber = row.getCell(CELL_NUMBERS.SAP_NUMBER.ordinal()).getStringCellValue();
        final String subNumber = row.getCell(CELL_NUMBERS.SUB_NUMBER.ordinal()).getStringCellValue();
        final String inventoryClass = row.getCell(CELL_NUMBERS.CLASS.ordinal()).getStringCellValue();
        final String description = row.getCell(CELL_NUMBERS.DESCRIPTION.ordinal()).getStringCellValue();
        final String introductionDateString = row.getCell(CELL_NUMBERS.INTRODUCTION_DATE.ordinal()).getStringCellValue();
        final String serialNumber = row.getCell(CELL_NUMBERS.SERIAL_NUMBER.ordinal()).getStringCellValue();
        final String inventoryNumber = row.getCell(CELL_NUMBERS.INVENTORY_NUMBER.ordinal()).getStringCellValue();
        final double isMarked = row.getCell(CELL_NUMBERS.IS_MARKED.ordinal()).getNumericCellValue();
        final String departmentNumber = row.getCell(CELL_NUMBERS.DEPARTMENT_NUMBER.ordinal()).getStringCellValue();
        final String departmentDescription = row.getCell(CELL_NUMBERS.DEPARTMENT_DESCRIPTION.ordinal()).getStringCellValue();
        final double planCount = row.getCell(CELL_NUMBERS.PLAN_COUNT.ordinal()).getNumericCellValue();
        final double objectsCount = row.getCell(CELL_NUMBERS.OBJECTS_COUNT.ordinal()).getNumericCellValue();
        final double isNewNumber = row.getCell(CELL_NUMBERS.IS_NEW.ordinal()).getNumericCellValue();
        final double isDeletedNumber = row.getCell(CELL_NUMBERS.IS_DELETED.ordinal()).getNumericCellValue();
        final String typeLabel = row.getCell(CELL_NUMBERS.TYPE_LABEL.ordinal()).getStringCellValue();
        final double initialCost = row.getCell(CELL_NUMBERS.INITIAL_COST.ordinal()).getNumericCellValue();
        final double leastCost = row.getCell(CELL_NUMBERS.LEAST_COST.ordinal()).getNumericCellValue();
        final String responsiblePersonName = row.getCell(CELL_NUMBERS.RESPONSIBLE_PERSON_NAME.ordinal()).getStringCellValue();
        final double responsiblePersonTableNumber = row.getCell(CELL_NUMBERS.RESPONSIBLE_PERSON_TABLE_NUMBER.ordinal()).getNumericCellValue();
        final String location = row.getCell(CELL_NUMBERS.LOCATION.ordinal()).getStringCellValue();

        return new ParsedRowStruct(
                barcode,
                sapNumber,
                subNumber,
                inventoryClass,
                description,
                introductionDateString,
                serialNumber,
                inventoryNumber,
                isMarked,
                departmentNumber,
                departmentDescription,
                planCount,
                objectsCount,
                isNewNumber,
                isDeletedNumber,
                typeLabel,
                initialCost,
                leastCost,
                responsiblePersonName,
                responsiblePersonTableNumber,
                location);
    }

}
