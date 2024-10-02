package com.pluralsight.strings;

public class Donut {
    private String description;
    private int calories;
    private double priceOfDonut;

    public Donut(String description, int calories, double priceOfDonut) {
        this.description = description;
        this.calories = calories;
        this.priceOfDonut = priceOfDonut;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public double getPriceOfDonut() {
        return priceOfDonut;
    }
    @Override
    public String toString() {

        //runs faster than concatenation
        final StringBuilder sb = new StringBuilder("");
//        sb.append("description='").append(description);
//        sb.append("calories='").append(calories);
//        sb.append("price='").append(price);
//        sb.append('}');
        sb.append(description).append(" has ");
        sb.append(calories).append(" calories");


        return sb.toString();
    }
}
