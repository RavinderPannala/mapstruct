package com.example.nisum.MapStruct.exception;

public class ValidatorException extends RuntimeException {

    public ValidatorException(String message) {
        super(message);
    }

    public ValidatorException(String message, Throwable throwable) {
        super(message, throwable);
    }
}
