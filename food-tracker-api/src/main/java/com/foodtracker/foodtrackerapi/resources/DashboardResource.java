package com.foodtracker.foodtrackerapi.resources;

import com.foodtracker.foodtrackerapi.models.Product;
import com.foodtracker.foodtrackerapi.models.Recipe;
import com.foodtracker.foodtrackerapi.services.ProductService;
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
@RequestMapping("/api/dashboard")
public class DashboardResource {

    @Autowired
    RecipeService recipeService;

    @Autowired
    ProductService productService;

    @GetMapping("/popular")
    public Optional<Recipe> getMostPopularRecipe(){
        return recipeService.getMostPopularRecipe();
    }

    @GetMapping("/type")
    public Optional<Recipe> getRecipeByType(@RequestBody Map<String, Object> recipeMap){
        String type = (String) recipeMap.get("TYPE");
        return recipeService.getRecipeByType(type);
    }

    @GetMapping("/shortexp")
    public List<Product> getProductWithShortExpDate(){
        return productService.getProductWithShortExpDate();
    }


}
