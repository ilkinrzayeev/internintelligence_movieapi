package com.example.moviedevelopment.exceptions;

public class EmptyDatabaseException extends RuntimeException {
    public EmptyDatabaseException(String message) {
        super(message);
    }
}
