package com.foodtracker.foodtrackerapi.repositories;

import java.util.List;
import java.util.Optional;

import com.foodtracker.foodtrackerapi.models.Product;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ShoppingListRepositoryImpl implements ShoppingListRepository{

    @Override
    public Optional<List<Product>> getAllProductsInCurrentShoppingList(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Optional<List<Product>> getAllProductsInOldShoppingList(int userId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer updateAllItemsOldShoppingList(int userId, List<Product> oldShoppingList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer updateAllItemsCurrentShoppingList(int userId, List<Product> currentShoppingList) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer addProductInCurrentShoppingList(int userId, Product newProduct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer addProductInOldShoppingList(int userId, Product newProduct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer updateProductInCurrentShoppingList(int userId, Product newProduct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer updateProductInOldShoppingList(int userId, Product newProduct) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer deleteProductInCurrentShoppingList(int userId, int productId) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Integer deleteProductInOldShoppingList(int userId, int productId) {
        // TODO Auto-generated method stub
        return null;
    }
}
