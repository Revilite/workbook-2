package com.pluralsight.strings;

public class Donut {
    String description;
    int calories;
    double priceOfDonut;

    @Override
    public String toString() {
        return "Donut{" +
                "description='" + description + '\'' +
                ", calories=" + calories +
                ", priceOfDonut=" + priceOfDonut +
                '}';
    }
}
