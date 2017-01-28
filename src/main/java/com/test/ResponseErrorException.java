package com.test;

public class ResponseErrorException extends RuntimeException {

    public ResponseErrorException(String message) {
        super(message);
    }
}
