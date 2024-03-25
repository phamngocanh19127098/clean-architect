package com.example.presenters;

import com.example.domain.Identity;
import com.example.presenters.entity.ApiResponse;
import com.example.usecase.UseCaseExecutor;
import com.example.usecase.circular.ReadCircularUseCase;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/circular")
public class CircularController {

    private final UseCaseExecutor useCaseExecutor;
    private final ReadCircularUseCase readCircularUseCase;
    public CircularController(UseCaseExecutor useCaseExecutor, ReadCircularUseCase readCircularUseCase) {
        this.useCaseExecutor = useCaseExecutor;
        this.readCircularUseCase = readCircularUseCase;
    }

    @GetMapping("/{id}")
    public ApiResponse findById(@PathVariable("id") String id) {
        return  useCaseExecutor.execute(readCircularUseCase,
                ReadCircularUseCase.InputValues.builder()
                        .withIdentity(Identity.builder().withId(id).build())
                        .build()
                );
    }
}
