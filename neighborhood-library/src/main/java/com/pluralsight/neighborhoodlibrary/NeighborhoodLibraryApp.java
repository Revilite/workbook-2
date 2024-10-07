package com.pluralsight.neighborhoodlibrary;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class NeighborhoodLibraryApp {
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner scan = new Scanner(System.in);

        //Main method string variables
        String bold = "\033[1m";
        String reset = "\033[1;0m";

        //scans CSV file and skips the heading row
        ArrayList<Book> library = new ArrayList();
        Scanner scanCSV = new Scanner(new File("X:/pluralsight/workbook-2/neighborhood-library/src/main/java/com/pluralsight/neighborhoodlibrary/books.csv"));
        String[] tempValues = scanCSV.nextLine().split(",");

        //creates library
        while (scanCSV.hasNextLine()) {
            tempValues = scanCSV.nextLine().split(",");
            library.add(new Book(Integer.parseInt(tempValues[0]), tempValues[1], tempValues[2], Boolean.parseBoolean(tempValues[3]), tempValues[4]));
        }

        System.out.print("""
                 \033[9m                                          \033[0m
                |                                          |
                |  \033[1m Welcome to the Neighborhood Library!\033[1;0m   |
                |                                          |
                 \033[9m                                          \033[0m
                """);
        boolean loop = true;
        while (loop) {
            System.out.print("""
                    
                    please choose a option:
                    Show Available Books (1)
                    Show Checked Out Books (2)
                    Exit Program (3)
                    
                    """);

            String choice = scan.nextLine();

            //To checkout
            if (choice.equals("1")) {
                for (int i = 0; i < library.size(); i++) {
                    if (!library.get(i).isCheckedOut()) {
                        System.out.println(library.get(i).printAvailableBook());
                    }
                }
                System.out.println(bold + """
                        \nWould you like to check out a book?
                        Check out book (C)
                        Exit Available Books (X)
                        """ + reset);
                String checkOutBookChoice = scan.nextLine();

                switch (checkOutBookChoice) {
                    case "C", "c": {
                        for (Book b : library) {
                            if (!b.isCheckedOut()) {
                                System.out.println(b.printAvailableBook());
                            }
                        }
                        boolean choiceLoop = true;
                        while (choiceLoop) {
                            System.out.println("\nWhat is the title of the book?");
                            System.out.println("type \'Stop\' to go back");
                            String bookName = scan.nextLine().toLowerCase();
                            if (bookName.equals("stop")) {
                                break;
                            }
                            for (Book b : library) {
                                if (b.getTitle().toLowerCase().contains(bookName)) {
                                    System.out.println("What is your name?");
                                    String name = scan.nextLine();
                                    b.checkOut(name);
                                    choiceLoop = false;
                                }
                            }
                            if (choiceLoop) {
                                System.out.println("Invalid Book Name");
                            } else {
                                System.out.println("Enjoy your book!");
                                Thread.sleep(1000);
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
            }
            //to put back
            else if (choice.equals("2")) {
                for (Book b : library) {
                    if (b.isCheckedOut()) {
                        System.out.println(b.printCheckoutBook());
                    }
                }
                System.out.println("");
                System.out.println("""
                        Would you like to return a book?
                        Check in a book (C)
                        Go back to home screen (X)
                        """);
                String returnBook = scan.nextLine();

                switch (returnBook) {
                    case "C", "c": {
                        System.out.println("What is the ID of the book?");
                        int id = scan.nextInt();
                        scan.nextLine();
                        library.get(id - 1).checkIn();
                        System.out.println("Thank you!");
                        Thread.sleep(1000, 0);
                    }
                    case "X", "x": {
                        break;
                    }
                    default: {
                        System.out.println("Im sorry I don't understand");
                    }
                }
            } else if (choice.equals("3")) {
                loop = false;
            } else {
                System.out.println("Please choose one of the options");
            }
        }
    }
}
