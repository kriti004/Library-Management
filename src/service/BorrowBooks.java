package service;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.*;

public class BorrowBooks {

    public static void borrowBooks() throws IOException {
        File file = new File("file4.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (row.getCell(2).getStringCellValue().equals("booked")) {
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

    public static void main(String[] args) throws IOException {
        borrowBooks();
    }

    public void borrow() throws IOException {
        Scanner sc = new Scanner(System.in);

        AvailableBooks available = new AvailableBooks();
        available.availableBooks();

        System.out.println("Choose a book");
        String book = sc.nextLine();

        File file = new File("file4.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);

        for (Row row : sheet) {
            if (row.getCell(0).getStringCellValue().equals(book) && row.getCell(2).getStringCellValue().equals("unbooked")) {
                row.getCell(2).setCellValue("booked");
                System.out.println("Book has been borrowed!");
            }
        }
        try (FileOutputStream outputStream = new FileOutputStream("file4.xls")) {
            wb.write(outputStream);
        }
    }
}

