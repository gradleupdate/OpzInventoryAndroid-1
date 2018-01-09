package com.opz.oasu.inventory.service;

import android.os.Handler;
import android.app.Application;
import android.content.res.Resources;
import android.os.Looper;
import android.util.Log;
import android.widget.ProgressBar;

import com.opz.oasu.inventory.R;
import com.opz.oasu.inventory.model.entity.Nomenclature;

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
public class WbSvc {

    private static final String LOGGER_TAG = WbSvc.class.getName();

    private static final String MAIN_SHEET_NAME = "Лист1";

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

    public List<Nomenclature> readWb(File wbFile, ProgressBar progressBar) {
        Log.d(LOGGER_TAG, LOGGER_SOURCE_WORKBOOK_VALIDITY_CHECKING_START);

        final String filePath = wbFile.getPath();
        final String sourceFileExtension = filePath.substring(filePath.lastIndexOf(".") + 1);
        List<Nomenclature> readingResult;
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

    private List<Nomenclature> readXls(File wbFile, final ProgressBar progressBar) throws IOException {
        List<Nomenclature> readingResult = new ArrayList<>();
        HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(wbFile));
        HSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
        Handler progressBarHandler = new Handler(Looper.getMainLooper());
        int lastRowNum = mainSheet.getLastRowNum();
        progressBar.setMax(lastRowNum);
        for (int i = 1; i <= lastRowNum; i++) {
            HSSFRow row = mainSheet.getRow(i);
            logWbRow(row);
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

    private List<Nomenclature> readXlsx(File wbFile, final ProgressBar progressBar) throws IOException {
        List<Nomenclature> readingResult = new ArrayList<>();
        XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(wbFile));
        XSSFSheet mainSheet = workbook.getSheet(MAIN_SHEET_NAME);
        Handler progressBarHandler = new Handler(Looper.getMainLooper());
        int lastRowNum = mainSheet.getLastRowNum();
        progressBar.setMax(lastRowNum);
        for (int i = 1; i <= lastRowNum; i++) {
            XSSFRow row = mainSheet.getRow(i);
            logWbRow(row);
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

    private void logWbRow(Row row) {
        Log.i(LOGGER_TAG,
                "Read data from row " + row.getRowNum() + ":\n" +
                        "\tbarcode: "                           + row.getCell(0)    .getStringCellValue()   + ";\n" +
                        "\tSAP number: "                        + row.getCell(1)    .getStringCellValue()   + ";\n" +
                        "\tsubnumber: "                         + row.getCell(2)    .getStringCellValue()   + ";\n" +
                        "\tclass: "                             + row.getCell(3)    .getStringCellValue()   + ";\n" +
                        "\tname: "                              + row.getCell(4)    .getStringCellValue()   + ";\n" +
                        "\tintroduction date: "                 + row.getCell(5)    .getStringCellValue()   + ";\n" +
                        "\tserial number: "                     + row.getCell(6)    .getStringCellValue()   + ";\n" +
                        "\tinventory number: "                  + row.getCell(7)    .getStringCellValue()   + ";\n" +
                        "\tis marked: "                         + row.getCell(8)    .getNumericCellValue()  + ";\n" +
                        "\tdepartment number: "                 + row.getCell(9)    .getStringCellValue()   + ";\n" +
                        "\tdepartment name: "                   + row.getCell(10)   .getStringCellValue()   + ";\n" +
                        "\tplan count: "                        + row.getCell(11)   .getNumericCellValue()  + ";\n" +
                        "\tobjects count: "                     + row.getCell(12)   .getNumericCellValue()  + ";\n" +
                        "\tis new: "                            + row.getCell(13)   .getNumericCellValue()  + ";\n" +
                        "\tis deleted: "                        + row.getCell(14)   .getNumericCellValue()  + ";\n" +
                        "\ttype label: "                        + row.getCell(15)   .getStringCellValue()   + ";\n" +
                        "\tinitial cost: "                      + row.getCell(17)   .getNumericCellValue()  + ";\n" +
                        "\tleast cost: "                        + row.getCell(18)   .getNumericCellValue()  + ";\n" +
                        "\tresponsible person name: "           + row.getCell(19)   .getStringCellValue()   + ";\n" +
                        "\tresponsible person table number: "   + row.getCell(20)   .getNumericCellValue()  + ";\n" +
                        "\tlocation: "                          + row.getCell(21)   .getStringCellValue()   + ";\n");
    }
}
