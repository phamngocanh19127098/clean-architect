package com.dailycodebuffer.Springboot.tutorial.presenters;

import com.dailycodebuffer.Springboot.tutorial.domain.Identity;
import com.dailycodebuffer.Springboot.tutorial.presenters.entity.ApiResponse;
import com.dailycodebuffer.Springboot.tutorial.presenters.entity.CircularResponse;
import com.dailycodebuffer.Springboot.tutorial.usecase.UseCaseExecutor;
import com.dailycodebuffer.Springboot.tutorial.usecase.circular.CreateCircularUseCase;
import com.dailycodebuffer.Springboot.tutorial.usecase.circular.ReadCircularUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
