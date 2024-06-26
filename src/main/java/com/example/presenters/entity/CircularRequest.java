package com.example.presenters.entity;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", setterPrefix = "with")
@JsonDeserialize(builder = CircularRequest.Builder.class)
public class CircularRequest {
    String name;
    String description;
}
