package com.food.kart.foodkart.exceptions;

public class UserNotPresent  extends  RuntimeException{
    public UserNotPresent(String message) {
        super(message);
    }
}
