package com.foodtracker.foodtrackerapi.resources;

import com.foodtracker.foodtrackerapi.models.Recipe;
import com.foodtracker.foodtrackerapi.services.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/recipe")
public class RecipeResource {

    @Autowired
    RecipeService recipeService;

    @GetMapping("/type")
    public Optional<Recipe> getRecipeByType(@RequestBody Map<String, Object> recipeMap){
        String type = (String) recipeMap.get("TYPE");
        return recipeService.getRecipeByType(type);
    }

    @GetMapping("/id")
    public Optional<Recipe> getRecipeByID(@RequestBody Map<String, Integer> recipeMap){
        int id = (Integer) recipeMap.get("ID");
        return recipeService.getRecipeByID(id);
    }

    @GetMapping("/rating")
    public Optional<Recipe> getRecipeByRating(@RequestBody Map<String, Object> recipeMap){
        Double rating = (Double) recipeMap.get("RATING");
        return recipeService.getRecipeByRating(rating);
    }

    @GetMapping("/popular")
    public Optional<Recipe> getMostPopularRecipe(){
        return recipeService.getMostPopularRecipe();
    }

    @GetMapping("/all")
    public List<Recipe> getAllRecipes(){
        return recipeService.getAllRecipes();
    }
}
