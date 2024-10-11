package service;

import java.io.IOException;
import java.util.Scanner;



public class Manage {

    public void add() throws IOException {
        BooksInfo booksInfo = new BooksInfo();
        booksInfo.getBooksInfo();
    }

    public void showBorrowed() throws IOException {
        BorrowBooks borrow = new BorrowBooks();
        borrow.borrow();
    }

    public static void addUser(String name, String dob) throws IOException {
        UserInfoService service = new UserInfoService();
        service.loadAllUser(name, dob);
    }

    public void run() throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name");
        String name = sc.nextLine();
        System.out.println("Enter your dob");
        String dob = sc.nextLine();
        addUser(name, dob);
        StringBuilder options = new StringBuilder();
        options.append("You wanna add a book or borrow?\n")
                .append("1. Add\n")
                .append("2. Borrow");

        System.out.println(options.toString());
        String reply = sc.nextLine();
        if (reply.equals("1")) {
            add();
        } else {
            showBorrowed();
        }

    }


}
