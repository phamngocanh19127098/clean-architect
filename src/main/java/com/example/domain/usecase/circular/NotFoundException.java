package com.example.domain.usecase.circular;

public class NotFoundException extends DomainException  {
    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String messageFormat, Object... args) {
        super(String.format(messageFormat, args));
    }

    public static NotFoundException of(String value) {
        return new NotFoundException(value);
    }
}
