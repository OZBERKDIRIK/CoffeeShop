package org.example;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class CoffeeFactory {
    private static final Map<Integer , CoffeeRecipe> recipes = new HashMap<>();

    static {
        addCoffee(1,new CoffeeRecipe("Espresso", 20,Map.of("Espresso",1)));
        addCoffee(2 ,new CoffeeRecipe("Double Espresso", 27,Map.of("Espresso",2)));
        addCoffee(3 , new CoffeeRecipe("Cappucino", 28,Map.of("Espresso",1 , "Süt" , 2,"Süt Köpüğü",2)));
        addCoffee(4 , new CoffeeRecipe("Caffe Latte", 28,Map.of("Espresso",1 , "Süt" , 3,"Süt Köpüğü",1)));
        addCoffee(5 ,new CoffeeRecipe("Mocha", 32,Map.of("Espresso",1 , "Süt" , 1 , "Süt Köpüğü",1, "Sıcak Çikolata" ,2)));
        addCoffee(6 ,new CoffeeRecipe("Americano",26, Map.of("Espresso",1 , "Sıcak Su" , 4)));
        addCoffee(7, new CoffeeRecipe("Hot Water", 5,Map.of("Sıcak Su",5 )));
    }
     public static CoffeeRecipe getCoffee(int coffeeType) {
        return recipes.get(coffeeType);
    }

    public static void listCoffees() {
        recipes.forEach((key, recipe) -> {
            System.out.println(key + ": " + recipe.getName() +" " +recipe.getPrice());
        });
    }
    public static void addCoffee(int type, CoffeeRecipe recipe) {
        if (recipes.containsKey(type)) {
            throw new IllegalArgumentException("Kahve zaten eklenmiş");
        }
        recipes.put(type, recipe);
    }

    public static Map<Integer, CoffeeRecipe> getRecipes() {
        return Collections.unmodifiableMap(recipes);
    }

    public static void clearRecipes() {
        recipes.clear();
    }
    public static void setRecipes(Map<Integer, CoffeeRecipe> newRecipes) {
        recipes.clear();
        recipes.putAll(newRecipes);
    }
}
