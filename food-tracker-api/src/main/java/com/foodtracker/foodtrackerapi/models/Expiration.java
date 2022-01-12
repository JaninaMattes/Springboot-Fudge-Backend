package com.foodtracker.foodtrackerapi.models;

public enum Expiration {
    MEAT("Meat", 3),
    FISH("Fish", 3),
    FLOUR("Flour", 150),
    VEGETABLE("Vegetable", 10),
    FRUIT("Fruit", 10);

    private String label;
    private Integer days;

    public String getLabel() {
        return label;
    }

    public Integer getDays() {
        return days;
    }

    Expiration(String label, Integer days) {
        this.label = label;
        this.days = days;
    }
}
