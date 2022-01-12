package com.foodtracker.foodtrackerapi.models;

import java.util.ArrayList;
import java.util.Objects;

public class Productlist {

    private Integer listId;
    private ArrayList<Product> productList = new ArrayList<Product>();

    public Integer getListId() {
        return listId;
    }

    public void setListId(Integer listId) {
        this.listId = listId;
    }

    public ArrayList<Product> getProductList() {
        return productList;
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void addProductToProductList(Product p){
        this.productList.add(p);
    }

    public void removeProductOfProductList(Product p){
        this.productList.remove(p);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Productlist)) return false;
        Productlist that = (Productlist) o;
        return Objects.equals(listId, that.listId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(listId);
    }

    @Override
    public String toString() {
        return "Productlist{" +
                "productList=" + productList +
                '}';
    }
}
