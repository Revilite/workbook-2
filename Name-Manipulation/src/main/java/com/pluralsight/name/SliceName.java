package com.pluralsight.name;

import java.util.Scanner;

public class SliceName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please enter your full name: ");
        String fullName = scan.nextLine();

        String[] splitName = fullName.split(" ");

        System.out.println(splitName[1]);
        if (splitName.length == 2) {
            System.out.println("First name: " + splitName[0]);
            System.out.println("Middle name: (none)");
            System.out.println("First name: " + splitName[1]);
        } else if (splitName.length == 3){
            System.out.println("First name: " + splitName[0]);
            System.out.println("Middle name: " + splitName[1]);
            System.out.println("Last name: " + splitName[2]);
        }
    }
}
