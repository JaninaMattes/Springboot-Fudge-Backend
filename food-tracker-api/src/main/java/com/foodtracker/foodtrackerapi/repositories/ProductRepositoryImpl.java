package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductRepositoryImpl implements  ProductRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    private static final String SQL_INSERT = "INSERT INTO ET_PRODUCT(PRODUCT_ID, USER_ID, SHOPPINGLIST_ID," +
            " INVENTORYLIST_ID, PRODUCT_NAME, EXPIRATION_DATE, QUANTITY, MANUFACTURER, NUTRITION_VALUE, IMAGE_URL ) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SQL_DELETE_PRODUCT = "DELETE FROM ET_PRODUCT WHERE PRODUCT_ID = ?;";
    private static final String SQL_GET_PRODUCT_WITH_SHORT_EXPDATE = "SELECT * FROM ET_PRODUCT " +
            "WHERE EXPIRATION_DATE <= CURRENT_DATE + 3;";

    @Override
    public Integer updateProductInventoryListByID(Integer id, List<Product> inventory) {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public Integer deleteProductOnInventoryList(Integer id) {
        return jdbcTemplate.update(SQL_DELETE_PRODUCT, id);
    }

    @Override
    public Integer addProductToInventoryList(Product product, int user_id, int shoppinglist_id, int inventorylist_id) {

        return jdbcTemplate.update(SQL_INSERT, product.getProductId(), user_id, shoppinglist_id, inventorylist_id,
                product.getProductName(), product.getExpirationDate(), product.getQuantity(), product.getManufacturer(),
                product.getNutritionValue(), product.getImageUrl());
    }

    @Override
    public List<Product> getProductWithShortExpDate() {
        try{
            List <Product> products = jdbcTemplate.query(SQL_GET_PRODUCT_WITH_SHORT_EXPDATE, productRowMapper);
        return products;
        }
        catch (Exception e){
            System.out.println("Fehler");
            return null;
        }

    }

    private RowMapper<Product> productRowMapper = ((rs, rowNum) -> {
        return new Product(
                rs.getInt("PRODUCT_ID"),
                rs.getString("PRODUCT_NAME"),
                rs.getDate("EXPIRATION_DATE"),
                rs.getInt("QUANTITY"),
                rs.getString("MANUFACTURER"),
                rs.getString("NUTRITION_VALUE")
        );
    });

}

