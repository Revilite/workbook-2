package com.pluralsight.logic;
/**
 * this is a public class that illustrates side effect of using
 * different data types in a formulae
 */
public class LogicExamples {
    public static void main(String[] args) {
//        System.out.println("Hello");


        double area = 10 / 3;
        double remainder = 10 % 3;

        area = (float) 10 / 3;

        float y = 7.99f;

        double z = 8.99f;

        System.out.println(area);
        System.out.println(remainder);
        System.out.println(y);
        System.out.println(z);

        boolean amIDone = false;
        int counter = 0;

        do {
            System.out.println("talking... words.....");
            if (counter++ == 5) amIDone = true;
        } while (!amIDone);


        counter = 0;
        while (counter != 5) {
            System.out.println("talking... words...");
            counter++;
        }

        for(int i = 0; i < 5; i++){
            System.out.println("Talking...  words...");
        }
        if (counter > 0){
            System.out.println("We talked about it");
        }
    }


}
