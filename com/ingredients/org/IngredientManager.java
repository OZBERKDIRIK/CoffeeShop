package com.ingredients.org;

import java.util.HashMap;
import java.util.Map;

public class IngredientManager {
    private Map<String , BaseIngredient> ingredients;

    public IngredientManager(){
        ingredients=new HashMap<>();
        initializeIngredients();
    }


    private void initializeIngredients(){
        addIngredient(new BaseIngredient("Espresso", 10));
        addIngredient(new BaseIngredient("Hot Water", 2));
        addIngredient(new BaseIngredient("Milk", 7));
        addIngredient(new BaseIngredient("Milk Foam", 4));
        addIngredient(new BaseIngredient("Hot Chocolate", 10));
    }
    public void addIngredient(BaseIngredient ingredient) {
        ingredients.put(ingredient.getName(), ingredient);
    }

    public BaseIngredient getIngredient(String name) {
        return ingredients.get(name);
    }

    public Map<String, BaseIngredient> getAllIngredients() {
        return ingredients;
    }
}
