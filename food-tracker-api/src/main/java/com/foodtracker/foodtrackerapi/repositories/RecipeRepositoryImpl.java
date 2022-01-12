package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.models.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RecipeRepositoryImpl implements RecipeRepository{
    
    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_GET_ALL_RECIPES = "SELECT * FROM ET_RECIPE; ";
    private static final String SQL_GET_MOST_POPULAR_RECIPE = "SELECT * FROM ET_RECIPE ORDER BY RATING DESC LIMIT 1;";
    private static final String SQL_GET_RECIPE_BY_ID = "SELECT * FROM ET_RECIPE WHERE RECIPE_ID = ?;";
    private static final String SQL_GET_RECIPE_BY_TYPE = "SELECT * FROM ET_RECIPE WHERE RECIPE_DESCRIPTION = ?;";
    private static final String SQL_GET_RECIPE_BY_RATING = "SELECT * FROM ET_RECIPE WHERE RATING = ?;";

    @Override
    public List<Recipe> getAllRecipesByRatingAndMatchWithInventory(int userId) {
        return null;
        // TODO Auto-generated method stub
    }

    @Override
    public List<Recipe> getFiveMostPopularRecipes() {
        // TODO Auto-generated method stub
        return null;
    }
    
    @Override
    public Optional<Recipe> getMostPopularRecipe() {
        try {
            List<Recipe> recipe = jdbcTemplate.query(SQL_GET_MOST_POPULAR_RECIPE, recipeRowMapper);
            return recipe.stream().findFirst();

        }catch (Exception e) {
            System.out.println("Error in getMostPopularRecipe");
        }
        return null;
    }

    @Override
    public Optional<Recipe> getRecipeByRating(double rating) {
        try {
            List<Recipe> recipe = jdbcTemplate.query(SQL_GET_RECIPE_BY_RATING, recipeRowMapper, rating);
            System.out.println(recipe);
            System.out.println(recipe.stream().findFirst());
            return recipe.stream().findFirst();

        }catch (Exception e) {
            System.out.println("Error in getRecipeByRating");
        }
        return null;
    }

    @Override
    public Optional<Recipe> getRecipeById(int id) {

        try {
            List<Recipe> recipe = jdbcTemplate.query(SQL_GET_RECIPE_BY_ID, recipeRowMapper, id);
            System.out.println(recipe);
            System.out.println(recipe.stream().findFirst());
            return recipe.stream().findFirst();
        }catch (Exception e) {
            System.out.println("Error in getRecipeByID");
        }
        return null;
    }

    @Override
    public Optional<Recipe> getRecipeByType(String type) {
        try {
            List<Recipe> recipe = jdbcTemplate.query(SQL_GET_RECIPE_BY_TYPE, recipeRowMapper, type);

            return recipe.stream().findFirst();
        }catch (Exception e) {
            System.out.println("Error in getRecipeByType");
        }
        return null;
    }

    @Override
    public List<Recipe> getAllRecipes() {
        try {
            List<Recipe> recipes = jdbcTemplate.query(SQL_GET_ALL_RECIPES, recipeRowMapper);
            return recipes;
        }catch(Exception e){
            System.out.println(
                    "Fehler"
            );
        }
        return null;
    }

    private RowMapper<Recipe> recipeRowMapper = (rs, rowNum) -> {
        System.out.println("Hallo");
        return new Recipe(rs.getInt("RECIPE_ID"),
            rs.getString("TITLE") ,
            rs.getString("RECIPE_DESCRIPTION") 
            /**,
            rs.getInt("RATING"),
            rs.getInt("COOKING_TIME"),
            rs.getString("DIFFICULTY"),
            rs.getString("INSTRUCTIONS"),
            rs.getString("NUTRITIONAL_VALUE")
         **/
         );
    };

    @Override
    public List<Recipe> getAllRecipesByRating(int rating) {
        // TODO Auto-generated method stub
        return null;
    }

}
