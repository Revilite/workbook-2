package com.pluralsight.name;
import java.util.Scanner;


public class ConcatName {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //Gathers user imput
        System.out.println("Please enter your name");
        System.out.println("First Name:");
        String firstName = scan.nextLine();
        System.out.println("Middle Name:");
        String middleName = scan.nextLine();
        System.out.println("Last Name:");
        String lastName = scan.nextLine();
        System.out.println("Suffix:");
        String suffix = scan.nextLine();

        //Builds String
        StringBuilder sb = new StringBuilder(firstName.trim()).append(" ");

        //If the name after trim is all white space, skip appending
        if(!middleName.trim().isEmpty()){
        sb.append(middleName).append(" ");
        }
        if(!lastName.trim().isEmpty()){
        sb.append(lastName).append(" ");
        }
        if(!suffix.trim().isEmpty()){
        sb.append(suffix).append("");
        }

        //Print output
        System.out.println("Full name " + sb);

    }

}
