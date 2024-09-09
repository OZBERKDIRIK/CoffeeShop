package com.coffee.org;

import com.ingredients.org.BaseIngredient;

import java.util.HashMap;
import java.util.Map;

public abstract class BaseCoffee implements CoffeeDetails {
    protected String name;
    protected Map<BaseIngredient, Integer> ingredients;

    public BaseCoffee(String name) {
        this.name = name;
        this.ingredients = new HashMap<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addIngredient(BaseIngredient ingredient, int dose) {
        ingredients.put(ingredient, ingredients.getOrDefault(ingredient, 0) + dose);
    }

    @Override
    public void removeIngredient(BaseIngredient ingredient) {
        ingredients.remove(ingredient);
    }

    @Override
    public double calculatePrice() {
        double totalPrice = 0.0;
        for (Map.Entry<BaseIngredient, Integer> entry : ingredients.entrySet()) {
            totalPrice += entry.getKey().getPricePerDose() * entry.getValue();
        }
        return totalPrice;
    }

    @Override
    public Map<BaseIngredient, Integer> getIngredients() {
        return ingredients;
    }

    @Override
    public String toString() {
        return name + " içierisinde  " + ingredients.toString() +"bulunur";
    }
}
