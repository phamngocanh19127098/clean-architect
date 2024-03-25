package com.example.usecase.circular;

import com.example.domain.Circular;
import com.example.domain.Identity;
import com.example.usecase.UseCase;
import lombok.Builder;
import lombok.Value;

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
