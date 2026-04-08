package com.hospitalManagementSystem.demo.repositories;

import com.hospitalManagementSystem.demo.entities.Insurance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsuranceRepository extends JpaRepository<Insurance, Long> {
}
