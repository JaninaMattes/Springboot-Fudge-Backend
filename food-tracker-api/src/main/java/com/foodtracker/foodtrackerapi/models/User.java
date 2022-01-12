package com.foodtracker.foodtrackerapi.models;

import java.util.ArrayList;
import java.util.Objects;

public class User {

    private Integer userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Settings userSettings;
    private String imgUrl;
    private ArrayList<Recipe> cookedRecipes = new ArrayList<>();
    private ArrayList<Tag> dietaryPreferences = new ArrayList<>();

    public User(Integer userId, String firstName, String lastName, String email, String password) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public User(Integer userId, String firstName, String lastName, String email, String password, String imgUrl) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.imgUrl = imgUrl;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImgUrl() {
        return this.imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Settings getUserSettings() {
        return this.userSettings;
    }

    public void setUserSettings(Settings userSettings) {
        this.userSettings = userSettings;
    }

    public ArrayList<Recipe> getRecipes() {
        return this.cookedRecipes;
    }

    public void setRecipes(ArrayList<Recipe> recipes) {
        this.cookedRecipes = recipes;
    }

    public ArrayList<Tag> getDietaryPreferences() {
        return dietaryPreferences;
    }

    public void setDietaryPreferences(ArrayList<Tag> dietaryPreferences) {
        this.dietaryPreferences = dietaryPreferences;
    }

    public void addRecipe(Recipe recipe){
        this.cookedRecipes.add(recipe);
    }

    public void removeRecipe(Recipe recipe){
        this.cookedRecipes.remove(recipe);
    }

    public void addDietryPreference(Tag t){
        this.dietaryPreferences.add(t);
    }

    public void removeDietryPreference(Tag t){
        this.dietaryPreferences.remove(t);
    }

    // TODO
    public void rateRecipe(Integer rating, Recipe recipe){}

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return userId.equals(user.userId) && firstName.equals(user.firstName) && lastName.equals(user.lastName) &&
                email.equals(user.email) && password.equals(user.password) && Objects.equals(cookedRecipes, user.cookedRecipes) &&
                Objects.equals(dietaryPreferences, user.dietaryPreferences);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, firstName, lastName, email, password, cookedRecipes, dietaryPreferences);
    }
}
