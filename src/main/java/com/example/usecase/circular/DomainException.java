package com.example.usecase.circular;

public abstract class DomainException extends RuntimeException {
    public DomainException(String message) {
        super(message);
    }
}
