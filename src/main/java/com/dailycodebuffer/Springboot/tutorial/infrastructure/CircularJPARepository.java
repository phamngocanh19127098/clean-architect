package com.dailycodebuffer.Springboot.tutorial.infrastructure;

import com.dailycodebuffer.Springboot.tutorial.infrastructure.entity.CircularEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircularJPARepository extends JpaRepository<CircularEntity, String> {
}
