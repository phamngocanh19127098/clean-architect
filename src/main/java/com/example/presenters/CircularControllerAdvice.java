package com.example.presenters;

import com.example.presenters.entity.ApiResponse;
import com.example.usecase.circular.DomainException;
import com.example.usecase.circular.NotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.Instant;

@ControllerAdvice
@Slf4j
public class CircularControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ApiResponse> customNotFoundException(NotFoundException ex) {
        log.error("NotFoundException: {}", ex.toString());

        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        ApiResponse apiResponse = ApiResponse.builder()
                .withTimestamp(Instant.now())
                .withStatus(httpStatus.value())
                .withReason(httpStatus.getReasonPhrase())
                .withMessage(ex.getMessage())
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse, httpStatus);
    }

    @ExceptionHandler(value = {DomainException.class})
    public ResponseEntity<ApiResponse> customDomainException(DomainException ex) {
        log.error("DomainException: {}", ex.toString());

        HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiResponse apiResponse = ApiResponse.builder()
                .withTimestamp(Instant.now())
                .withStatus(httpStatus.value())
                .withReason(httpStatus.getReasonPhrase())
                .withMessage(ex.getMessage())
                .build();
        return new ResponseEntity<ApiResponse>(apiResponse, httpStatus);
    }
}
