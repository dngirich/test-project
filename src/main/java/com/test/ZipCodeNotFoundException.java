package com.test;

public class ZipCodeNotFoundException extends RuntimeException {

    public ZipCodeNotFoundException(String message) {
        super(message);
    }
}
