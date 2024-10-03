package com.pluralsight.name;

import java.util.Scanner;
import java.util.ArrayList;

public class SliceName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Consumes name from user
        System.out.println("Please enter your full name: ");
        String fullName = scan.nextLine().trim();

        //Splits into array
        String[] splitName = fullName.split(" ");
        ArrayList<String> list = new ArrayList<>();

        //Removes empty spaces from array and adds it into a new arraylist
        int count = 0;
        for (int i = 0; i < splitName.length; i++) {
            if (!splitName[i].isEmpty()) {
                list.add(splitName[i].trim());
            }
        }


        //Chooses whether the name has a middle name and prints accordingly
        if (list.size() == 2) {
            System.out.println("First name: " + list.get(0));
            System.out.println("Middle name: (none)");
            System.out.println("First name: " + list.get(1));
        } else if (list.size() == 3) {
            System.out.println("First name: " + list.get(0));
            System.out.println("Middle name: " + list.get(1));
            System.out.println("Last name: " + list.get(2));
        }
    }
}
