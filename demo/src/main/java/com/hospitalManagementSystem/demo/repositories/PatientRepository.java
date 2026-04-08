package com.hospitalManagementSystem.demo.repositories;

import com.hospitalManagementSystem.demo.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
