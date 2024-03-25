package com.example.domain.usecase;

import com.example.presenters.entity.ApiResponse;

public interface UseCaseExecutor {
    <I extends UseCase.InputValue, O extends UseCase.OutputValue> ApiResponse execute(UseCase<I, O> useCase, I input);

}
