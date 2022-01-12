package com.foodtracker.foodtrackerapi.repositories;

import com.foodtracker.foodtrackerapi.exceptions.FTAuthException;
import com.foodtracker.foodtrackerapi.models.User;

public interface UserRepository {

    Integer create(String firstName, String lastName, String email, String password) throws FTAuthException;

    User findByEmailAndPassword(String email, String password) throws FTAuthException;

    Boolean isUserLoggedIn(Integer userId);

    Integer getCountByEmail(String email);

    User findById(Integer userId);

}
