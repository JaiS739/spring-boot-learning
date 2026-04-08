package com.hospitalManagementSystem.demo.entities;

import com.hospitalManagementSystem.demo.entities.type.BloodGroup;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Cascade;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Table(name="PatientTable")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;


    private String name;

    private LocalDate birthDate;

    private String email;

    private String gender;

    @Enumerated(value = EnumType.STRING)
    private BloodGroup bloodGroup;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}) // this column will be automatically unique
    @JoinColumn(name = "patient_insurance", unique = true)  // this JoinColumn will work only in owning side
    private Insurance insurance; //owning side

    @OneToMany(mappedBy = "patient")
    private Set<Appointment> appointmentSet = new HashSet<>();

}
