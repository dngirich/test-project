package com.test.exception;

public class AdressNotFoundException extends RuntimeException {

    public AdressNotFoundException(String message) {
        super(message);
    }
}
