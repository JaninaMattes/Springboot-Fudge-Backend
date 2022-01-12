package com.foodtracker.foodtrackerapi.services;

import com.foodtracker.foodtrackerapi.models.Product;

import java.util.List;

public interface ProductService {

    public Integer deleteProductOnInventoryList(Integer id);

    public Integer addProductToInventoryList(Product product, int userId, int shoppinglistId, int inventorylistId);

    public Integer updateProductInventoryListByID(Integer id, List<Product> inventoryList);
    
    public List<Product> getProductWithShortExpDate();
}
