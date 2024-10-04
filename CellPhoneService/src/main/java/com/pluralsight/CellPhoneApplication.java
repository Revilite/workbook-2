package com.pluralsight;

import java.util.Scanner;


public class CellPhoneApplication {

    public static void display(CellPhone phone) {
        System.out.println("The serial number is: " + phone.getSerialNumber());
        System.out.println("The model is: " + phone.getModel());
        System.out.println("The carrier is: " + phone.getCarrier());
        System.out.println("The phone number is: " + phone.getPhoneNumber());
        System.out.println("The serial number is: " + phone.getOwner());
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        //Exercise 1
        CellPhone phone = new CellPhone();
        System.out.println("What is the serial number?");
        int serialNumber = 98723838;
//        int serialNumber = scan.nextInt();
//        scan.nextLine();
        System.out.println("What model is the phone?");
        String model = "Iphone 14 Pro Max";
//        String model = scan.nextLine();
        System.out.println("What is the carrier?");
        String carrier = "Verizon";
//        String carrier = scan.nextLine();
        System.out.println("What is the phone number??");
        String phoneNumber = "(980)-269-4835";
//        String phoneNumber = scan.nextLine();
        System.out.println("Who is the owner of the phone??");
        String owner = "Jacob :)";
//        String owner = scan.nextLine();

        phone.setSerialNumber(serialNumber);
        phone.setModel(model);
        phone.setCarrier(carrier);
        phone.setPhoneNumber(phoneNumber);
        phone.setOwner(owner);

        System.out.println(phone.getSerialNumber());
        System.out.println(phone.getModel());
        System.out.println(phone.getCarrier());
        System.out.println(phone.getPhoneNumber());
        System.out.println(phone.getOwner());


        //Exercise 2
        CellPhone phone2 = new CellPhone();
        phone2.setSerialNumber(1239898);
        phone2.setModel("Google Pixel 9");
        phone2.setCarrier("T-Mobile");
        phone2.setPhoneNumber("(713)-283-1232");
        phone2.setOwner("Neon");

        display(phone);
        display(phone2);

        phone.dial(phone2.getPhoneNumber());
        phone2.dial(phone.getPhoneNumber());

    }
}
