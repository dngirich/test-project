package com.test.exception;

public class ZipCodeNotFoundException extends RuntimeException {

    public ZipCodeNotFoundException(String message) {
        super(message);
    }
}
