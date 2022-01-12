package com.foodtracker.foodtrackerapi.models;

public class Settings {

    private Integer settingsId;
    private Boolean allowPushNotifications = false; // per default on false
    private Boolean remindBeforeProductExpiration = false;
    private Boolean suggestProductsForShoppingList = false;


    public Settings(Integer settingsId, Boolean allowPushNotications, Boolean remindBeforeProductExpiration, Boolean suggestProductsForShopping){
        this.settingsId = settingsId;
        this.allowPushNotifications = allowPushNotications;
        this.remindBeforeProductExpiration = remindBeforeProductExpiration;
        this.suggestProductsForShoppingList = suggestProductsForShopping;
    }

}
