package com.java.lld.design.java;

public class AccountException extends RuntimeException {
    public AccountException(String message) {
        super(message);
    }

    public AccountException(String message, Throwable cause) {
        super(message, cause);
    }

    public static class AccountNotFoundException extends AccountException {
        public AccountNotFoundException(String id) {
            super("Account not found with id: " + id);
        }
    }

    public static class DuplicateUsernameException extends AccountException {
        public DuplicateUsernameException(String username) {
            super("Username already exists: " + username);
        }
    }

    public static class InvalidCredentialsException extends AccountException {
        public InvalidCredentialsException() {
            super("Invalid username or password");
        }
    }
}
