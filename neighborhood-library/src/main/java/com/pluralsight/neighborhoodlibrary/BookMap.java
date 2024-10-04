package com.pluralsight.neighborhoodlibrary;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class BookMap {
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    //String colors
    String reset = "\033[1;0m";
    String blueForeground = "\033[1;34m";
    String magentaForeground = "\033[1;35m";
    String redForeground = "\033[1;31m";


    public BookMap(int id, String title, String isbn, boolean isCheckedOut, String checkedOutTo) {
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

    public String printAvailableBooks() {
        StringBuilder sb = new StringBuilder();
        if (this.isCheckedOut == false) {
            sb.append(blueForeground).append("Book Title: ").append(this.title).append(reset);
            sb.append(magentaForeground).append(" Book Id: ").append(this.id).append(reset);
            sb.append(redForeground).append(" Book ISBN: ").append(this.isbn).append(reset);
        }
        return sb.toString();
    }

    public String printCheckoutBooks() {
        StringBuilder sb = new StringBuilder();
        if (this.isCheckedOut == true) {
            sb.append("Book Title: ").append(this.title);
            sb.append(" Book Id: ").append(this.id);
            sb.append(" Book ISBN: ").append(this.isbn);
            sb.append(" Who has this book? ").append(this.checkedOutTo);
        }
        return sb.toString();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        Scanner scan = new Scanner(System.in);

        //Creating Hashmap and scanning CSV file :(
        HashMap<String, BookMap> library = new HashMap<>();
        Scanner scanCSV = new Scanner(new File("X:/pluralsight/workbook-2/neighborhood-library/src/main/java/com/pluralsight/neighborhoodlibrary/books.csv"));

        //creates the books object then loads into the library hashmap
        String[] tempValues = scanCSV.nextLine().split(",");
        int bookCounter = 0;
        while (scanCSV.hasNextLine()) {
            tempValues = scanCSV.nextLine().split(",");
            library.put("book" + bookCounter, new BookMap(Integer.parseInt(tempValues[0]), tempValues[1], tempValues[2], Boolean.parseBoolean(tempValues[3]), tempValues[4]));
            bookCounter++;
        }

        //Starts showing the screens
        boolean mainLoop = true;
        while (mainLoop) {
            System.out.println("""
                    Welcome to the Neighbrhood Library!
                    
                    please choose a option:
                    Show Available Books (1)
                    Show Checked Out Books (2)
                    Exit Program (3)
                    
                    """);

            String choice = scan.nextLine();

            //To checkout
            if (choice.equals("1")) {
                for (int i = 0; i < library.size(); i++) {
                    if (!library.get("book" + i).isCheckedOut()) {
                        System.out.println(library.get("book" + i).printAvailableBooks());
                    }
                }
                System.out.println("""
                        \n\nWould you like to check out a book?
                        Check out book (C)
                        Exit Available Books (X)
                        """);

                String checkOutBookChoice = scan.nextLine();

                switch (checkOutBookChoice) {
                    case "C", "c": {
                        boolean choiceLoop = true;
                        while (choiceLoop) {
                            System.out.println("What is the title of the book?");
                            String bookName = scan.nextLine().toLowerCase();
                            for (int i = 0; i < library.size(); i++) {
                                if (library.get("book" + i).getTitle().toLowerCase().contains(bookName)) {
                                    System.out.println("What is your name?");
                                    String name = scan.nextLine();
                                    library.get("book" + i).checkOut(name);
                                    choiceLoop = false;
                                }
                            }
                            if (choiceLoop) {
                                System.out.println("Invalid Book Name");
                            }
                        }
                    }
                    case "X", "x": {
                        break;
                    }
                    default: {
                        System.out.println("Im sorry, I don't understand");
                    }
                }
            } else if (choice.equals("2")) {
                System.out.println("");
                for (int i = 0; i < library.size(); i++) {
                    if (library.get("book" + i).isCheckedOut) {
                        System.out.println(library.get("book" + i).printCheckoutBooks());
                    }
                }

                System.out.println("Would you like to return a book?");
                System.out.println("Check in a book (C)");
                System.out.println("Go back to home screen (X)");
                String returnBook = scan.nextLine();

                switch (returnBook) {
                    case "C", "c": {
                        System.out.println("What is the ID of the book?");
                        int id = scan.nextInt();
                        scan.nextLine();
                        library.get("book" + (id - 1)).checkIn();
                        System.out.println("Thank you!");
                        Thread.sleep(1000, 0);
                    }
                    case "X", "x": {
                        break;
                    }
                }
            } else if (choice.equals("3")) {
                mainLoop = false;
            } else {
                System.out.println("Please choose one of the options\n");
            }
        }
    }
}