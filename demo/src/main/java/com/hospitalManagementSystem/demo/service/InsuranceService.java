package com.hospitalManagementSystem.demo.service;

import com.hospitalManagementSystem.demo.entities.Insurance;
import com.hospitalManagementSystem.demo.entities.Patient;
import com.hospitalManagementSystem.demo.repositories.InsuranceRepository;
import com.hospitalManagementSystem.demo.repositories.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        return insurance;
    }

}
