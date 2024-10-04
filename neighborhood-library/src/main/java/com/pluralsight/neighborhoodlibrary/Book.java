package com.pluralsight.neighborhoodlibrary;

public class Book {
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;

    //String colors
    String reset = "\033[1;0m";
    String blueForeground = "\033[1;34m";
    String magentaForeground = "\033[1;35m";
    String redForeground = "\033[1;31m";
    String greenForeground = "\033[1;32m";


    public Book(int id, String title, String isbn, boolean isCheckedOut, String checkedOutTo) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        isCheckedOut = checkedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    public void setCheckedOutTo(String checkedOutTo) {
        this.checkedOutTo = checkedOutTo;
    }


    public void checkOut(String name) {
        this.isCheckedOut = true;
        this.checkedOutTo = name;
    }

    public void checkIn() {
        this.checkedOutTo = "";
        this.isCheckedOut = false;
    }

    public String printAvailableBook() {
        StringBuilder sb = new StringBuilder();
        if (this.isCheckedOut == false) {
            sb.append(blueForeground).append("Book Title: ").append(this.title).append(reset);
            sb.append(magentaForeground).append(" Book Id: ").append(this.id).append(reset);
            sb.append(redForeground).append(" Book ISBN: ").append(this.isbn).append(reset);
        }
        return sb.toString();
    }

    public String printCheckoutBook() {
        StringBuilder sb = new StringBuilder();
        if (this.isCheckedOut == true) {
            sb.append(blueForeground).append("Book Title: ").append(this.title).append(reset);
            sb.append(magentaForeground).append(" Book Id: ").append(this.id).append(reset);
            sb.append(redForeground).append(" Book ISBN: ").append(this.isbn).append(reset);
            sb.append(greenForeground).append(" Who has this book? ").append(this.checkedOutTo).append(reset);
        }
        return sb.toString();
    }

}
