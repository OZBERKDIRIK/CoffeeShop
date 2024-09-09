package com.coffee.org;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class CoffeeRecipeLoader {
    private static final String RECIPES_FILE = "recipes.json";

    public static List<CoffeeRecipe> loadRecipes() {
        try (FileReader reader = new FileReader(RECIPES_FILE)) {
            Gson gson = new Gson();
            Type recipeListType = new TypeToken<List<CoffeeRecipe>>(){}.getType();
            return gson.fromJson(reader, recipeListType);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load recipes", e);
        }
    }
}
