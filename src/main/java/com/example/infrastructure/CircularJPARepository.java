package com.example.infrastructure;

import com.example.infrastructure.entity.CircularEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CircularJPARepository extends JpaRepository<CircularEntity, String> {
}
