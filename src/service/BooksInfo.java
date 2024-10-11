package service;

import enitities.Book;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.io.*;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.TreeMap;


public class BooksInfo {
    public void getBooksInfo() throws IOException {

        Book book = new Book();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the Book Name");
        String title = scanner.nextLine();

        System.out.println("Enter the Author Name");
        String author = scanner.nextLine();

        System.out.println("Enter its status");
        String status = scanner.nextLine();
        loadBooks(title, author, status);

    }

    public void loadBooks(String title, String author, String status) throws IOException {

        FileInputStream file = new FileInputStream("file4.xls");
        HSSFWorkbook workbook = new HSSFWorkbook(file);
        HSSFSheet sheet = workbook.getSheetAt(0);
        HSSFRow row;

        Map<String, Book> studentData = new TreeMap<>();
        Random random = new Random();
        String id = String.format("%04d", random.nextInt(10000));

        studentData.put(String.valueOf(Math.random()), new Book(title, author, status));

        for (Book book2 : studentData.values()) {

            int index = sheet.getPhysicalNumberOfRows();
            row = sheet.createRow(index);

            row.createCell(0).setCellValue(book2.getTitle());
            row.createCell(1).setCellValue(book2.getAuthor());
            row.createCell(2).setCellValue(book2.getStatus());
            row.createCell(3).setCellValue(id);

            try (FileOutputStream outputStream = new FileOutputStream("file4.xls")) {
                workbook.write(outputStream);
            }
        }
    }

    public void allBooks() throws IOException {
        File file = new File("file4.xls");
        FileInputStream fis = new FileInputStream(file);
        HSSFWorkbook wb = new HSSFWorkbook(fis);
        HSSFSheet sheet = wb.getSheetAt(0);
        for (Row row : sheet) {
            for (Cell cell : row) {
                if (cell.getCellTypeEnum().equals(CellType.STRING)) {
                    System.out.print(cell.getStringCellValue() + "\t");
                } else {
                    System.out.print(cell.getNumericCellValue() + "\t");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
