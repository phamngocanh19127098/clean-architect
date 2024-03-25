package com.dailycodebuffer.Springboot.tutorial.usecase;

import com.dailycodebuffer.Springboot.tutorial.presenters.entity.ApiResponse;

public interface UseCaseExecutor {
    <I extends UseCase.InputValue, O extends UseCase.OutputValue> ApiResponse execute(UseCase<I, O> useCase, I input);

}
