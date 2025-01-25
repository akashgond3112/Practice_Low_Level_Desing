package com.food.kart.foodkart.exceptions;

public class UserAlreadyPresent extends  RuntimeException {
    public UserAlreadyPresent(String message) {
        super(message);
    }
}
