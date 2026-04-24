package com.fawry.car.exceptions;

public class InvalidCarStateException extends RuntimeException {
    public InvalidCarStateException(String message) {
        super(message);
    }
}

