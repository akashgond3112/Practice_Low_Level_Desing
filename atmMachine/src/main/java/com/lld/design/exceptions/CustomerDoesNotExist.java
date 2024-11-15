package com.lld.design.exceptions;

public class CustomerDoesNotExist extends RuntimeException {
    public CustomerDoesNotExist(String message) {
        super(message);
    }
}
