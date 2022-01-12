package com.foodtracker.foodtrackerapi.services;

import com.foodtracker.foodtrackerapi.models.Product;
import com.foodtracker.foodtrackerapi.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

    @Autowired
    ProductRepository productRepository;


    @Override
    public Integer deleteProductOnInventoryList(Integer id) {
        return productRepository.deleteProductOnInventoryList(id);
    }

    @Override
    public Integer addProductToInventoryList(Product product, int user_id, int shoppinglist, int inventorylist) {
        return productRepository.addProductToInventoryList(product, user_id, shoppinglist, inventorylist);
    }

    @Override
    public Integer updateProductInventoryListByID(Integer id, List<Product> inventoryList) {
        return productRepository.updateProductInventoryListByID(id, inventoryList);
    }

    public List<Product> getProductWithShortExpDate(){
        return productRepository.getProductWithShortExpDate();
    }
}
