package enitities;

public class User {
    private int id;
    private String name;
    private String dob;
    private String book;


    public User() {
        return;
    }

    public User(String name, String dob, String book) {
        Book book1 = new Book();
        this.name = name;
        this.dob = dob;
        this.book = book;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }
}
