package com.coffee.org;

import java.util.Map;

public class CoffeeRecipe {
    private String name;
    private Map<String, Integer> ingredients;

    public CoffeeRecipe(String name, Map<String, Integer> ingredients) {
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public Map<String, Integer> getIngredients() {
        return ingredients;
    }
}
