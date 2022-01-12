package com.foodtracker.foodtrackerapi.models;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Objects;

public class Product {

    private Integer productId;
    private String productName;
    private Expiration productType;
    private Date expirationDate;
    private Float quantity;
    private String nutritionValue;
    private String manufacturer;
    private String imageUrl; // TODO Bilder korrekt in DB ablegen

    public Product(String productName, Float quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public Product(String productName, Expiration productType, Float quantity) {
        this.productName = productName;
        this.productType = productType;
        this.quantity = quantity;
        this.setExpirationDate();
    }

    public Product(int int1, String string, java.sql.Date date, int int2, String string2, String string3) {
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate() {
        Date current = getCurrentDate();
        this.expirationDate = DateUtil.addDays(current, this.productType.getDays());
        ;
    }

    public Float getQuantity() {
        return quantity;
    }

    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    public String getNutritionValue() {
        return nutritionValue;
    }

    public void setNutritionValue(String nutritionValue) {
        this.nutritionValue = nutritionValue;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public void updateExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    private Date getCurrentDate() {
        ZoneId defaultZoneId = ZoneId.systemDefault();
        LocalDate localDate = LocalDate.now();
        return Date.from(localDate.atStartOfDay(defaultZoneId).toInstant());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof Product))
            return false;
        Product product = (Product) o;
        return Objects.equals(productId, product.productId) && Objects.equals(productName, product.productName) &&
                Objects.equals(expirationDate, product.expirationDate) && Objects.equals(quantity, product.quantity) &&
                Objects.equals(nutritionValue, product.nutritionValue)
                && Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(imageUrl, product.imageUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, productName, expirationDate, quantity, nutritionValue, manufacturer, imageUrl);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productName='" + productName + '\'' +
                ", expirationDate=" + expirationDate +
                ", quantity=" + quantity +
                '}';

    }
}
