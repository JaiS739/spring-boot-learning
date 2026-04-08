package com.hospitalManagementSystem.demo;

import com.hospitalManagementSystem.demo.entities.Patient;
import com.hospitalManagementSystem.demo.repositories.PatientRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="/patients")
public class PatientController {
    private final PatientRepository patientRepository;

    public PatientController (PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @GetMapping()
    public List<Patient> getAllPatients (){
        return patientRepository.findAll();
    }
}
