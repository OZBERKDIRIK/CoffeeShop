package com.coffee.org;

import com.ingredients.org.BaseIngredient;
import com.ingredients.org.IngredientManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CoffeeFactory {
    private IngredientManager ingredientManager;
    private Map<String, CoffeeRecipe> coffeeRecipes;

    public CoffeeFactory(IngredientManager ingredientManager) {
        this.ingredientManager = ingredientManager;
        this.coffeeRecipes = new HashMap<>();
        loadRecipes();
    }

    private void loadRecipes() {
        List<CoffeeRecipe> recipes = CoffeeRecipeLoader.loadRecipes();
        for (CoffeeRecipe recipe : recipes) {
            coffeeRecipes.put(recipe.getName(), recipe);
        }
    }

    public CoffeeDetails createCoffee(String coffeeType, Map<String, Integer> additionalDoses) {
        CoffeeRecipe recipe = coffeeRecipes.get(coffeeType);
        if (recipe == null) {
            throw new IllegalArgumentException("Bilinmeyen Kahve Türü : " + coffeeType);
        }

        BaseCoffee coffee = new BaseCoffee(coffeeType) {};
        for (Map.Entry<String, Integer> entry : recipe.getIngredients().entrySet()) {
            BaseIngredient ingredient = ingredientManager.getIngredient(entry.getKey());
            if (ingredient != null) {
                coffee.addIngredient(ingredient, entry.getValue());
            }
        }

        for (Map.Entry<String, Integer> entry : additionalDoses.entrySet()) {
            BaseIngredient ingredient = ingredientManager.getIngredient(entry.getKey());
            if (ingredient != null) {
                coffee.addIngredient(ingredient, entry.getValue());
            }
        }

        return coffee;
    }
}
