package com.foodtracker.foodtrackerapi.models;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Recipe {

    private Integer recipeId;
    private String title;
    private String description;
    private Integer rating;
    private Duration cookingTime;
    private Difficulty difficulty;
    private String instructions;
    private String nutritionValue;
    private String imageUrl; // TODO Bilder korrekt in DB ablegen
    private ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();

    public Recipe(int int1, String string, String string2) {
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public Duration getCookingTime() {
        return cookingTime;
    }

    public void setCookingTime(Duration cookingTime) {
        this.cookingTime = cookingTime;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(String nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(ArrayList<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public void addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    public void removeIngredient(Ingredient ingredient) {
        this.ingredients.remove(ingredient);
    }

    public void addIngredientsToShoppingList(Boolean available){
        List<Ingredient> ingredients = new ArrayList<Ingredient>();
        ingredients = this.filterIngredientsBy(available);
        // TODO
    }

    private List<Ingredient> filterIngredientsBy(Boolean available){
        return this.ingredients.stream()
                .filter(p -> p.getAvailable().equals(available))
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", rating=" + rating +
                ", cookingTime=" + cookingTime +
                ", difficulty=" + difficulty +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Recipe)) return false;
        Recipe recipe = (Recipe) o;
        return Objects.equals(recipeId, recipe.recipeId) && Objects.equals(title, recipe.title) &&
                Objects.equals(description, recipe.description) && Objects.equals(rating, recipe.rating) &&
                Objects.equals(cookingTime, recipe.cookingTime) && difficulty == recipe.difficulty &&
                Objects.equals(instructions, recipe.instructions) && Objects.equals(nutritionValue, recipe.nutritionValue) &&
                Objects.equals(imageUrl, recipe.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipeId, title, description, rating, cookingTime, difficulty, instructions, nutritionValue, imageUrl);

    }
}
