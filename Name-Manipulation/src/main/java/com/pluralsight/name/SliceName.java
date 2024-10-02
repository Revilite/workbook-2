package com.pluralsight.name;

import java.util.Scanner;


public class SliceName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Consumes name from user
        System.out.println("Please enter your full name: ");
        String fullName = scan.nextLine().trim();


        //Splits into array
        String[] splitName = fullName.split(" ");
//        //Chooses whether the name has a middle name and prints accordingly
        if (splitName.length == 2) {
            System.out.println("First name: " + splitName[0]);
            System.out.println("Middle name: (none)");
            System.out.println("First name: " + splitName[1]);
        } else if (splitName.length == 3) {
            System.out.println("First name: " + splitName[0]);
            System.out.println("Middle name: " + splitName[1]);
            System.out.println("Last name: " + splitName[2]);
        }
    }
}
