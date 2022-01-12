package com.foodtracker.foodtrackerapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class FTAuthException extends RuntimeException {

    public FTAuthException(String message) {
        super(message);
        }
}