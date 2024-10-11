package service;

import enitities.User;

import java.io.*;
import java.util.*;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

public class UserInfoService {
    public void loadAllUser(String name,String dob) throws IOException {

        try {

            // Reading file from local directory
            FileInputStream file = new FileInputStream("file.xls");

            // Create Workbook instance holding reference to
            // .xlsx file
            HSSFWorkbook workbook = new HSSFWorkbook(file);

            // Get first/desired sheet from the workbook
            HSSFSheet sheet = workbook.getSheetAt(0);

            // Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();

            // Till there is an element condition holds true
            boolean present = false;
            while (rowIterator.hasNext()) {

                Row row = rowIterator.next();
                if (row.getCell(1) != null) {
                    if (row.getCell(1).getStringCellValue().equals(name)) {
                        if (row.getCell(2).getStringCellValue().equals(dob)) {
                            System.out.println("date matched.");
                            present = true;
                            break;
                        }
                    }
                }
            }

            if (!present) {
                HSSFRow row;
                Map<String, User> studentData
                        = new TreeMap<>();
                Random random = new Random();
                String id = String.format("%04d", random.nextInt(10000));

                allBooksInfo();
                Scanner scanner = new Scanner(System.in);

                System.out.println("Enter the book you want");
                String book = scanner.nextLine();

                studentData.put(String.valueOf(Math.random()), new User (name,dob,book));

                for (User user : studentData.values()) {

                    int index = sheet.getPhysicalNumberOfRows();
                    row = sheet.createRow(index);

                    row.createCell(0).setCellValue(index);
                    row.createCell(1).setCellValue(user.getName());
                    row.createCell(2).setCellValue(user.getDob());
                    row.createCell(3).setCellValue(user.getBook());
                    row.createCell(4).setCellValue(id);

                    try (FileOutputStream outputStream = new FileOutputStream("file.xls")) {
                        workbook.write(outputStream);
                    }
                }

            }
            file.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static void allBooksInfo() throws IOException {
        BooksInfo booksInfo = new BooksInfo();
        booksInfo.allBooks();
    }
}

