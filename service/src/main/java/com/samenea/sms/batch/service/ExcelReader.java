package com.samenea.sms.batch.service;

import com.samenea.sms.batch.model.PhoneInfo;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author: Soroosh Sarabadani
 * Date: 6/2/13
 * Time: 12:40 PM
 */
@Service
public class ExcelReader {
    private Logger logger = LoggerFactory.getLogger(ExcelReader.class);

    public List<PhoneInfo> getPhoneInfo(String excelPath) throws IOException {
        FileInputStream file = new FileInputStream(new File(excelPath));
        List<PhoneInfo> messageRecievers = new ArrayList<PhoneInfo>();

        HSSFWorkbook workbook = new HSSFWorkbook(file);
        final HSSFSheet sheet = workbook.getSheetAt(0);
        final Iterator<Row> rows = sheet.iterator();
        while (rows.hasNext()) {
            PhoneInfo phoneInfo = new PhoneInfo();
            final Row row = rows.next();
            final Iterator<Cell> cells = row.iterator();
            if (!cells.hasNext()) {
                break;
            }
            while (cells.hasNext()) {

                final Cell cell = cells.next();
                cell.setCellType(Cell.CELL_TYPE_STRING);
                final String value = cell.getStringCellValue();

                switch (cell.getColumnIndex()) {
                    case 0:
                        phoneInfo.setName(value);
                        break;
                    case 1:
                        phoneInfo.setLastName(value);
                        break;
                    case 2:
                        phoneInfo.setPhoneNumber(value);
                        break;
                    case 3:
                        phoneInfo.setEnable(value.trim().equals("1") ? true : false);
                        break;

                }

            }
            messageRecievers.add(phoneInfo);
        }

        return messageRecievers;
    }
}
