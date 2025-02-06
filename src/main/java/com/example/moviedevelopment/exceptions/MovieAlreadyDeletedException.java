package com.example.moviedevelopment.exceptions;

public class MovieAlreadyDeletedException extends RuntimeException {
    public MovieAlreadyDeletedException(String message) {
        super(message);
    }
}
