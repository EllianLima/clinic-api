package com.example.clinicApi.repositories;


import com.example.clinicApi.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository extends JpaRepository<Patient, Long> {
}
