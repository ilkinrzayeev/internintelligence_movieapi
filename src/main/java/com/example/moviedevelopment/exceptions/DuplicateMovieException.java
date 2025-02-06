package com.example.moviedevelopment.exceptions;

public class DuplicateMovieException extends RuntimeException {
    public DuplicateMovieException(String message) {
        super(message);
    }
}
