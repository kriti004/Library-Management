package service;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AvailableBooks {

    public void availableBooks() throws IOException {
        File file = new File("file4.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (row.getCell(2).getStringCellValue().equals("unbooked")) {
                    if (cell.getCellTypeEnum().equals(CellType.STRING)) {
                        System.out.print(cell.getStringCellValue() + " ");
                    } else {
                        System.out.print(cell.getNumericCellValue() + " ");
                    }
                }
            }
            System.out.println();
        }
        System.out.println();
    }

}



