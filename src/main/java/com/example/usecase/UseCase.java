package com.example.usecase;

public abstract class UseCase <I extends UseCase.InputValue, O extends UseCase.OutputValue> {
    public abstract O execute(I input);
    public interface InputValue {

    }
    public interface OutputValue {

    }
}
