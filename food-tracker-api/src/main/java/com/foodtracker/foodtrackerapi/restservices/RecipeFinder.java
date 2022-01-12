package com.foodtracker.foodtrackerapi.restservices;

import com.foodtracker.foodtrackerapi.models.Ingredient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class RecipeFinder {
    private static String API_KEY = " ";
    private static int NUMBER_OF_RECIPES = 5;

    public String getRecipeByIngredients(ArrayList<Ingredient> ingredientList) throws IOException, InterruptedException {
        String ingredients = "";
        for (Ingredient i:ingredientList) {
            ingredients += i.toString() + "%2C";
        }
        ingredients = ingredients.substring(0, ingredients.length()-3);
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://spoonacular-recipe-food-nutrition-v1.p.rapidapi.com/recipes/findByIngredients?ingredients="+ingredients+"&ranking=1&ignorePantry=true&number="+NUMBER_OF_RECIPES))
                .header("x-rapidapi-host", "spoonacular-recipe-food-nutrition-v1.p.rapidapi.com")
                .header("x-rapidapi-key", API_KEY)
                .method("GET", HttpRequest.BodyPublishers.noBody())
                .build();
        HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}