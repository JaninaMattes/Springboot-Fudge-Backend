package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.models.Product;

import java.util.List;

public interface ProductRepository {

    public Integer deleteProductOnInventoryList(Integer id);

    public Integer addProductToInventoryList(Product product, int user_id, int shoppinglist_id, int inventarylist_id);

    public Integer updateProductInventoryListByID(Integer id, List<Product> inventory);

    public List<Product> getProductWithShortExpDate();
}
