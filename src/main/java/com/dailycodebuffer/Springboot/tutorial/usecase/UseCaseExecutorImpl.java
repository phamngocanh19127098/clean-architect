package com.dailycodebuffer.Springboot.tutorial.usecase;

import com.dailycodebuffer.Springboot.tutorial.presenters.entity.ApiResponse;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
public class UseCaseExecutorImpl implements UseCaseExecutor{

    @Override
    public <I extends UseCase.InputValue, O extends UseCase.OutputValue> ApiResponse execute(UseCase<I, O> useCase, I input) {
        ApiResponse apiResponse = ApiResponse.builder()
                .withTimestamp(Instant.now())
                .withStatus(200)
                .withData(useCase.execute(input))
                .withMessage("success")
                .build();

        return apiResponse;
    }
}
