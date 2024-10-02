package com.pluralsight.strings;

import java.sql.SQLOutput;

public class StringsAndLoops {
    public static void main(String[] args) {


        //Strings and loops
        //Hard way to do things by repetition
//        System.out.println("Milk");
//        System.out.println("Cereal");
//        System.out.println("Sourdough bread");
//        System.out.println("Chips");
//        System.out.println("Salsa dip");
//        System.out.println("Queso");
//        System.out.println("Cream cheese");
//        System.out.println("Guac");
//        System.out.println("Bagels");
//        System.out.println("Everything Seasoning"); //:)

        //Starts at 0
        String[] list = {"Milk", "Cereal", "Sourdough Bread", "Chips", "Salsa dip", "Queso", "Cream Cheese", "Guac", "Bagels", "Everything Seasoning"};
        //Don't repeat yourself
        for (int i = 0; i < list.length; i++) {
//            System.out.println(list[i]);
        }
        //For each loop
        for(String s: list){
//            System.out.println(s);
        }

        String lists = "Milk,Cereal,Sourdough Bread,Chips,Salsa,Queso,Cream Cheese,Guac,Bagels,Everything Seasoning";
       lists = lists.replace(",", "\n");
//        System.out.println(lists);
        String[] allListItems = lists.split(("\n"));
//        System.out.println(allListItems[0]);

        String newList = """
                Milk    
                    Cereal
                        Sourdough Bread
                                      Chips
                                          Salsa
                                               Queso
                                                   Cream Cheese
                                                              Guac
                                                                   Bagels
                                                                         Everything Sesoning
                """;
//        System.out.println(newList);




        //public calling
//        Donut d = new Donut();
//        d.description = "Big Fluffy Donut with a cherry on top";
//        d.calories = 499;
//        d.priceOfDonut = 3.99;
//
//        Donut d2 = new Donut();
//
//        d2.description = "Chocolate cake donut";
//        d2.calories = 399;
//        d2.priceOfDonut = 1;

//        System.out.println(d);
//        System.out.println(d2);

        //<----------------->

        Donut donut = new Donut("Big Fluffy Donut with a cherry on top", 499, 3.99);

        Donut donut2 = new Donut("Chocolate cake donut", 399, 1.99);

        System.out.println(donut);
        printDonut(donut);
        printDonutAsCSV(donut2);











    }

    public static void printDonut(Donut donut){
        System.out.println(donut.getDescription());
        System.out.printf("Which costs $%.2f\n", donut.getPriceOfDonut());
    }

    public static void printDonutAsCSV(Donut d){
       final StringBuilder sb = new StringBuilder(d.getDescription());
       sb.append(",").append(d.getCalories());
       sb.append(",").append(d.getPriceOfDonut());

        System.out.println(sb);
    }
}
