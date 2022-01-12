package com.foodtracker.foodtrackerapi.services;

import com.foodtracker.foodtrackerapi.exceptions.FTAuthException;
import com.foodtracker.foodtrackerapi.models.User;

public interface UserService {

    User validateUser(String email, String password) throws FTAuthException;

    User registerUser(String firstName, String lastName, String email, String password) throws FTAuthException;
}
