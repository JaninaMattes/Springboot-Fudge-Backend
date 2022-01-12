package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.models.Product;

import java.util.List;
import java.util.Optional;

public interface ShoppingListRepository {

    public Optional<List<Product>> getAllProductsInCurrentShoppingList(int userId);

    public Optional<List<Product>> getAllProductsInOldShoppingList(int userId);

    public Integer updateAllItemsOldShoppingList(int userId, List<Product> oldShoppingList);

    public Integer updateAllItemsCurrentShoppingList(int userId, List<Product> currentShoppingList);

    public Integer addProductInCurrentShoppingList(int userId, Product newProduct);

    public Integer addProductInOldShoppingList(int userId, Product newProduct);

    public Integer updateProductInCurrentShoppingList(int userId, Product newProduct);

    public Integer updateProductInOldShoppingList(int userId, Product newProduct);

    public Integer deleteProductInCurrentShoppingList(int userId, int productId);

    public Integer deleteProductInOldShoppingList(int userId, int productId);
}
