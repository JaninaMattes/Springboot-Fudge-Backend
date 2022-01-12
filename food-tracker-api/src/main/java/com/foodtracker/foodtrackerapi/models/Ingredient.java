package com.foodtracker.foodtrackerapi.models;

import java.util.Objects;

public class Ingredient extends Product{

    private Boolean available = false;

    public Boolean getAvailable() {
        return this.available;
    }

    public void setStatus(Boolean status) {
        this.available = status;
    }

    public Ingredient(String productName, Float quantity) {
        super(productName, quantity);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ingredient)) return false;
        if (!super.equals(o)) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(available, that.available);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), available);
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "available='" + available + '\'' +
                '}';
    }
}
