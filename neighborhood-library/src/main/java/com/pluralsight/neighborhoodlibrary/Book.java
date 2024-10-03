package com.pluralsight.neighborhoodlibrary;

import java.lang.Thread;
import java.util.Scanner;


public class Book {
    int id;
    String isbn;
    String title;
    boolean isCheckedOut;
    String checkedOutTo;

    public Book(int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo) {
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
            sb.append("Book Title: ").append(this.title);
            sb.append(" Book Id: ").append(this.id);
            sb.append(" Book ISBN: ").append(this.isbn);
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


    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", isCheckedOut=" + isCheckedOut +
                ", checkedOutTo='" + checkedOutTo + '\'' +
                '}';
    }

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);

        //Pain and suffering
        Book book1 = new Book(1, "978-1-23456-789-0", "The Whispering Woods", false, "");
        Book book2 = new Book(2, "978-1-23456-790-7", "Shadows of the Past", false, "");
        Book book3 = new Book(3, "978-1-23456-791-4", "Echoes of Tomorrow", false, "");
        Book book4 = new Book(4, "978-1-23456-792-1", "The Last Ember", false, "");
        Book book5 = new Book(5, "978-1-23456-793-8", "Journey to the Unknown", false, "");
        Book book6 = new Book(6, "978-1-23456-794-5", "Beneath the Surface", false, "");
        Book book7 = new Book(7, "978-1-23456-795-2", "A Dance with Destiny", false, "");
        Book book8 = new Book(8, "978-1-23456-796-9", "The Clockmaker’s Secret", false, "");
        Book book9 = new Book(9, "978-1-23456-797-6", "The Forgotten Realm", false, "");
        Book book10 = new Book(10, "978-1-23456-789-0", "The Alchemist’s Apprentice", false, "");
        Book book11 = new Book(11, "978-1-23456-798-3", "Veil of Illusions", false, "");
        Book book12 = new Book(12, "978-1-23456-799-0", "The Edge of Infinity", false, "");
        Book book13 = new Book(13, "978-1-23456-800-3", "Threads of Fate", false, "");
        Book book14 = new Book(14, "978-1-23456-801-0", "The Serpent's Embrace", false, "");
        Book book15 = new Book(15, "978-1-23456-802-7", "The Mirror's Reflection", false, "");
        Book book16 = new Book(16, "978-1-23456-804-1", "A Heart in the Shadows", false, "");
        Book book17 = new Book(17, "978-1-23456-805-8", "The Song of the Stars", false, "");
        Book book18 = new Book(18, "978-1-23456-806-5", "The Hidden City", false, "");
        Book book19 = new Book(19, "978-1-23456-807-2", "The Fire Within", false, "");
        Book book20 = new Book(20, "978-1-23456-808-9", "The Luminous Path", false, "");

        //Creation of the library
        Book[] library = {book1, book2, book3, book4, book5, book6, book7, book8, book9, book10, book11, book12, book13,
                book14, book15, book16, book17, book18, book19, book20};


        boolean loop = true;
        while (loop) {
            System.out.println("Welcome to the Neighborhood Library!");
            System.out.println("Please choose a option:");
            System.out.println("Show Available Books (1)");
            System.out.println("Show Checked Out Books (2)");
            System.out.println("Exit Program (3)");


            int choice = scan.nextInt();
            scan.nextLine();

            //To checkout
            if (choice == 1) {
                for (int i = 0; i < library.length; i++) {
                    if (!library[i].isCheckedOut()) {
                        System.out.println(library[i].printAvailableBooks());
                    }
                }
                System.out.println("\n\nWould you like to check out a book?");
                System.out.println("Check out book (1)");
                System.out.println("Exit Available Books (2)");
                int checkOutBookChoice = scan.nextInt();
                scan.nextLine();

                if (checkOutBookChoice == 1) {
                    boolean choiceLoop = true;
                    while (choiceLoop) {
                        System.out.println("What is the title of the book?");
                        String bookName = scan.nextLine().toLowerCase();
                        for (int i = 0; i < library.length; i++) {
                            if (library[i].getTitle().toLowerCase().contains(bookName)) {
                                System.out.println("What is your name?");
                                String name = scan.nextLine();
                                library[i].checkOut(name);
                                choiceLoop = false;
                            }
                        }
                        if(choiceLoop) {
                            System.out.println("Invalid Book Name");
                        }
                    }
                }
                else if(checkOutBookChoice == 2){
                    continue;
                }
                else {
                    System.out.println("Im sorry, I don't understand");
                }
            }
            //to put back
            else if (choice == 2) {
                System.out.println("");
                for (int i = 0; i < library.length; i++) {
                    if (library[i].isCheckedOut()) {
                        System.out.println(library[i].printCheckoutBooks());
                    }

                }

                System.out.println("Would you like to return a book?");
                String returnBook = scan.nextLine();


                switch (returnBook) {
                    case "C", "c": {
                        System.out.println("What is the ID of the book?");
                        int id = scan.nextInt();
                        library[id].checkIn();
                        System.out.println("Thank you!");
                        Thread.sleep(2000, 0);

                    }
                }


            } else if (choice == 3) {
                loop = false;
            } else {
                System.out.println("\033[48;5;106m" + "Please choose one of the options" + "\033[0m");
            }


        }


    }


}
