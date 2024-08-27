package org.example;

import java.util.Map;

public class CoffeeRecipe {
    private String name ;

    private Map<String,Integer> ingredients;

    public CoffeeRecipe(String name , Map<String, Integer> ingredients){
        this.name=name;
        this.ingredients=ingredients;
    }

    public String getName(){
        return name;
    }

    public void prepare(){
        System.out.println(name + "seçtiniz." + name + "içerisinde ");
        ingredients.forEach((ingredient , amount)->{
            System.out.println(amount + "doz" + ingredient);
        });
        System.out.println("Afiyet Olsun");
    }
}
