package com.openbet.api.exceptions;

public class NotExistsException extends Exception {
    public NotExistsException(String message) {
        super("Does not exist" + message);
    }
}
