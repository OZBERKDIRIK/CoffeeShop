package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoffeeFactory {
    private static final Map<Integer , CoffeeRecipe> recipes = new HashMap<>();

    static {
            recipes.put(1,new CoffeeRecipe("Espresso", Map.of("Espresso",1)));
            recipes.put(2 ,new CoffeeRecipe("Double Espresso", Map.of("Espresso",2)));
            recipes.put(3 ,new CoffeeRecipe("Americano", Map.of("Espresso",1 , "Sıcak Su" , 4)));
            recipes.put(4 , new CoffeeRecipe("Cappucino", Map.of("Espresso",1 , "Süt" , 2,"Süt Köpüğü",2)));
            recipes.put(5 , new CoffeeRecipe("Caffe Latte", Map.of("Espresso",1 , "Süt" , 3,"Süt Köpüğü",1)));
            recipes.put(6 ,new CoffeeRecipe("Mocha", Map.of("Espresso",1 , "Süt" , 1 , "Süt Köpüğü",1, "Sıcak Çikolata" ,2)));
            recipes.put(7, new CoffeeRecipe("Hot Water", Map.of("Sıcak Su",5 )));
    }
     public static CoffeeRecipe getCoffee(int coffeeType) {
        return recipes.get(coffeeType);
    }

    public static void listCoffees() {
        recipes.forEach((key, recipe) -> {
            System.out.println(key + ": " + recipe.getName());
        });
    }
    public static void addCoffee(int type, CoffeeRecipe recipe) {
        if (recipes.containsKey(type)) {
            throw new IllegalArgumentException("Coffee type already exists");
        }
        recipes.put(type, recipe);
    }

    public static Map<Integer, CoffeeRecipe> getRecipes() {
        return Collections.unmodifiableMap(recipes);
    }
}
