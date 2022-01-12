package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.models.Recipe;

import java.util.List;
import java.util.Optional;

public interface RecipeRepository {

    public List<Recipe> getAllRecipes(); // Get all recipes from external API

    public List<Recipe> getAllRecipesByRatingAndMatchWithInventory(int userId);

    public List<Recipe> getFiveMostPopularRecipes(); // Return only five best matching recipes

    public Optional<Recipe> getMostPopularRecipe();

    public Optional<Recipe> getRecipeByRating(double rating);

    public Optional<Recipe> getRecipeById(int id);

    public Optional<Recipe> getRecipeByType(String type);

    public List<Recipe> getAllRecipesByRating(int rating);

}
