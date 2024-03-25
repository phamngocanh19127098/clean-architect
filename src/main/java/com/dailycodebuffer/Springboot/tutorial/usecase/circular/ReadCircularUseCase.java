package com.dailycodebuffer.Springboot.tutorial.usecase.circular;

import com.dailycodebuffer.Springboot.tutorial.domain.Circular;
import com.dailycodebuffer.Springboot.tutorial.domain.Identity;
import com.dailycodebuffer.Springboot.tutorial.usecase.UseCase;
import lombok.Builder;
import lombok.Value;
import org.springframework.stereotype.Service;

public class ReadCircularUseCase extends UseCase<ReadCircularUseCase.InputValues, ReadCircularUseCase.OutputValues> {

    private final CircularRepository circularRepository;
    public ReadCircularUseCase (CircularRepository circularRepository) {
        this.circularRepository = circularRepository;
    }
    @Override
    public OutputValues execute(InputValues input) {
        return circularRepository.readByIdentity(input.getIdentity())
                .map(e -> OutputValues.builder().withCircular(e).build())
                .orElseThrow(() -> NotFoundException.of(input.identity.toString()));
    }
    @Value
    @Builder(setterPrefix = "with")
    public static class InputValues implements UseCase.InputValue {
        Identity identity;
    }

    @Value
    @Builder(setterPrefix = "with")
    public static class OutputValues implements UseCase.OutputValue {
        Circular circular;
    }
}
