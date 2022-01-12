package com.foodtracker.foodtrackerapi.services;

import com.foodtracker.foodtrackerapi.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeService {

    public Optional<Recipe> getRecipeByType(String type);

    public Optional<Recipe> getRecipeByID(int id);

    public Optional<Recipe> getRecipeByRating(double rating);

    public List<Recipe> getAllRecipes();

    public List<Recipe> getAllRecipesByRating(int rating);

    public List<Recipe> getAllRecipesByMatchingUserInventory(int userId);

    public Optional<Recipe> getMostPopularRecipe();

}
