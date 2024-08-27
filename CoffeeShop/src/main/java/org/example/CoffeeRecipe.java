package org.example;

import java.util.Collections;
import java.util.Map;

public class CoffeeRecipe {
    private String name ;
    private int price;

    private Map<String,Integer> ingredients;

    public CoffeeRecipe(String name , int price , Map<String, Integer> ingredients){
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Kahve ismi boş veya null olamaz");
        }
        if (ingredients == null || ingredients.isEmpty()) {
            throw new IllegalArgumentException("İçerik  boş veya null olamaz");
        }
        this.name=name;
        this.ingredients=ingredients;
        this.price=price;
    }

    public String getName(){
        return name;
    }

    public void prepare(){
        System.out.println(name + " seçtiniz. " + name + " içerisinde ");
        ingredients.forEach((ingredient , amount)->{
            System.out.println(amount + " doz " + ingredient + " içermektedir");
        });
        System.out.println("Afiyet Olsun");
    }

    public int getPrice(){
        return this.price;
    }
}
