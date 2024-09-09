package com.ingredients.org;

public class BaseIngredient {
    private String name;

    private double pricePerDose;

    public BaseIngredient (String name , double pricePerDose){
        this.name=name;
        this.pricePerDose=pricePerDose;
    }

    public String getName(){
        return name;
    }

    public double getPricePerDose(){
        return pricePerDose;
    }
}
