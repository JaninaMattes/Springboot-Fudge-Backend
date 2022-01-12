package com.foodtracker.foodtrackerapi.services;

import com.foodtracker.foodtrackerapi.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;

import com.foodtracker.foodtrackerapi.repositories.RecipeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeServiceImpl implements RecipeService{

    @Autowired
    RecipeRepository recipeRepository;

    @Override
    public List<Recipe> getAllRecipesByRating(int rating) {
        return recipeRepository.getAllRecipesByRating(rating);
    }

    @Override
    public List<Recipe> getAllRecipesByMatchingUserInventory(int userId) {
        // TODO implement filter logic here
        return recipeRepository.getAllRecipesByRatingAndMatchWithInventory(userId); 
    }

    @Override
    public Optional<Recipe> getRecipeByType(String type) {
        return recipeRepository.getRecipeByType(type);
    }

    @Override
    public Optional<Recipe> getRecipeByID(int id) {
        return recipeRepository.getRecipeById(id);
    }

    @Override
    public Optional<Recipe> getRecipeByRating(double rating) {
        return recipeRepository.getRecipeByRating(rating);
    }

    @Override
    public List<Recipe> getAllRecipes() {
        return recipeRepository.getAllRecipes();
    }

    @Override
    public Optional<Recipe> getMostPopularRecipe() {
        return recipeRepository.getMostPopularRecipe();
    }
}
