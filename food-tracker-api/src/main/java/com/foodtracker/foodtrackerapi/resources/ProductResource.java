package com.foodtracker.foodtrackerapi.resources;


import com.foodtracker.foodtrackerapi.models.Product;
import com.foodtracker.foodtrackerapi.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductResource {

    @Autowired
    ProductService productService;

    @PostMapping("/add")
    public Integer addProductToInventaryList(@RequestBody Map<String, Object> productMap){
        Integer id = (Integer) productMap.get("ID");
        int user_id = (int) productMap.get("USER_ID");
        int shoppinglist_id = (int) productMap.get("SHOPPINGLIST_ID");
        int inventorylist_id = (int) productMap.get("INVENTORYLIST_ID");
        String name = (String) productMap.get("NAME");
        String date = (String) productMap.get("EXPIRATION_DATE");
        Date expiration_date = Date.valueOf(date);
        Integer quantity = (Integer) productMap.get("QUANTITY");
        String manufacturer = (String) productMap.get("MANUFACTURER");
        String nutrition_value = (String) productMap.get("NUTRITION_VALUE");

        //String type = (String) productMap.get("TYPE");

        Product product = new Product(id, name, expiration_date, quantity, manufacturer, nutrition_value);

        return productService.addProductToInventoryList(product, user_id, shoppinglist_id, inventorylist_id);
    }

    @DeleteMapping
    public Integer deleteProductOnInventaryList(@RequestBody Map<String, Object> productMap){
        Integer id = (Integer) productMap.get("ID");
        return productService.deleteProductOnInventoryList(id);
    }

    //TODO
    @PutMapping("/update")
    public Integer updateProductIneventaryListByID(Integer id){
        return 0;
    }

}
