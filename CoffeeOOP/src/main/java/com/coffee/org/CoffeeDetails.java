package com.coffee.org;

import com.ingredients.org.BaseIngredient;

import java.util.Map;

public interface CoffeeDetails {
    String getName();
    void addIngredient(BaseIngredient ingredient, int dose);
    void removeIngredient(BaseIngredient ingredient);
    double calculatePrice();
    Map<BaseIngredient, Integer> getIngredients();
}
