package com.example.presenters.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Value;

import java.time.Instant;
import java.time.ZonedDateTime;

@Value
@Builder(setterPrefix = "with")
@JsonDeserialize(builder = ApiResponse.Builder.class)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    Instant timestamp;
    Integer status;
    String reason;
    String message;
    Object data;

    @JsonPOJOBuilder
    public static class Builder {
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
        private ZonedDateTime timestamp;
    }
}
