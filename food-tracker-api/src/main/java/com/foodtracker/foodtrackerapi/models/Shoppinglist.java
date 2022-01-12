package com.foodtracker.foodtrackerapi.models;

import java.util.ArrayList;

public class Shoppinglist extends Productlist{

    private Integer shoppingListId;
    private ArrayList<Product> lastUsedProductList = new ArrayList<Product>();

    public Shoppinglist(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public Integer getShoppingListId() {
        return shoppingListId;
    }

    public void setShoppingListId(Integer shoppingListId) {
        this.shoppingListId = shoppingListId;
    }

    public ArrayList<Product> getLastUsedProductList() {
        return lastUsedProductList;
    }

    public void setLastUsedProductList(ArrayList<Product> lastUsedProductList) {
        this.lastUsedProductList = lastUsedProductList;
    }

    public void addProductToShoppingList(Product product) {
        super.addProductToProductList(product);
    }
    public void moveProductToLastUsedProductList(Product product) {
        super.removeProductOfProductList(product);
        this.addProductToLastUsedProducts(product);
    }

    public void addProductToLastUsedProductList(Product product) {
        this.lastUsedProductList.add(product);
    }
    public void moveProductToShoppingList(Product product) {
        super.addProductToProductList(product);
        this.removeProductFromLastUsedProductList(product);
    }

    public void removeProductFromShoppingList(Product product){
        super.removeProductOfProductList(product);
    }

    public void removeProductFromLastUsedProductList(Product product){
        this.lastUsedProductList.remove(product);
    }

    public Product filterProductInShoppingList(String productName){
        return super.getProductList().stream()
                .filter(p -> p.getProductName().equals(productName))
                .findAny()
                .orElse(null);
    }

    public Product filterProductInLastUsedProducts(String productName){
        return this.lastUsedProductList.stream()
                .filter(p -> p.getProductName().equals(productName))
                .findAny()
                .orElse(null);
    }

    public void addProductToLastUsedProducts(Product p){
        this.lastUsedProductList.add(p);
    }

    public void removeProductToLastUsedProducts(Product p){
        this.lastUsedProductList.remove(p);
    }
}
