package com.pluralsight;

public class ForLoop {
    public static void main(String[] args) throws InterruptedException{
        for (int i = 10; i >= 0; i--){
            System.out.println(i);
            if(i == 0){
                System.out.println("Launch!");
            }
                Thread.sleep(1000);
        }
    }
}
