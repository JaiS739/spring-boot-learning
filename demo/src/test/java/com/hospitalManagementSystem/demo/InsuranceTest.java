package com.hospitalManagementSystem.demo;

import com.hospitalManagementSystem.demo.entities.Insurance;
import com.hospitalManagementSystem.demo.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {
    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void testAssignInsuranceToPatient(){
        Insurance insurance = Insurance.builder()
                .provider("HDFC Ergo")
                .policyNumber("HDFC_234")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();
        var updateInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);
        System.out.println(updateInsurance);
    }

}
