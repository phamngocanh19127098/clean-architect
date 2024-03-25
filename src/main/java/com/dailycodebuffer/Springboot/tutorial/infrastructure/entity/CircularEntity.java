package com.dailycodebuffer.Springboot.tutorial.infrastructure.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(exclude = {"name", "description"})
@Builder(builderClassName = "Builder", setterPrefix = "with", toBuilder = true)
@Entity
public class CircularEntity {
    @Id
    String id;
    String name;
    String description;
}
