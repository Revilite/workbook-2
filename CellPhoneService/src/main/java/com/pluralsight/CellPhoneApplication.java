package com.pluralsight;
import java.util.Scanner;

public class CellPhoneApplication {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        CellPhone phone = new CellPhone();

        System.out.println("What is the serial number?");
        int serialNumber = scan.nextInt();
        scan.nextLine();
        System.out.println("What model is the phone?");
        String model = scan.nextLine();
        System.out.println("What is the carrier?");
        String carrier = scan.nextLine();
        System.out.println("What is the phone number??");
        String phoneNumber = scan.nextLine();
        System.out.println("Who is the owner of the phone??");
        String owner = scan.nextLine();

        phone.setSerialNumber(serialNumber);
        phone.setModel(model);
        phone.setCarrier(carrier);
        phone.setPhoneNumeber(phoneNumber);
        phone.setOwner(owner);

        System.out.println(phone.getSerialNumber());
        System.out.println(phone.getModel());
        System.out.println(phone.getCarrier());
        System.out.println(phone.getPhoneNumeber());
        System.out.println(phone.getOwner());

    }
}
