package com.dailycodebuffer.Springboot.tutorial.domain;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(builderClassName = "Builder", setterPrefix = "with")
public class Circular {
    Identity id;
    String name;
    String description;
}
