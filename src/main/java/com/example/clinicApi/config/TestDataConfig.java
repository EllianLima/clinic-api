package com.example.clinicApi.config;


import com.example.clinicApi.entities.Appointment;
import com.example.clinicApi.entities.Doctor;
import com.example.clinicApi.entities.Patient;
import com.example.clinicApi.entities.Specialty;
import com.example.clinicApi.entities.enums.PaymentType;
import com.example.clinicApi.entities.enums.Status;
import com.example.clinicApi.repositories.AppointmentRepository;
import com.example.clinicApi.repositories.DoctorRepository;
import com.example.clinicApi.repositories.PatientRepository;
import com.example.clinicApi.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class TestDataConfig implements CommandLineRunner {

    @Autowired
    private AppointmentRepository appointmentRepository;

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private SpecialtyRepository specialtyRepository;

    @Override
    public void run(String... args) throws Exception {
        Specialty sp1 = new Specialty(null, "Cardiology");
        Specialty sp2 = new Specialty(null, "Pediatrics");

        specialtyRepository.saveAll(Arrays.asList(sp1, sp2));

        Doctor d1 = new Doctor(null, "Dr. Ana", "ana@clinic.com", "9999-1111", sp1);
        Doctor d2 = new Doctor(null, "Dr. João", "joao@clinic.com", "9999-2222", sp2);

        doctorRepository.saveAll(Arrays.asList(d1, d2));

        Patient p1 = new Patient(null, "Maria", "maria@gmail.com", "8888-1111");
        Patient p2 = new Patient(null, "Carlos", "carlos@gmail.com", "8888-2222");

        patientRepository.saveAll(Arrays.asList(p1, p2));

        Appointment ap1 = new Appointment(null, d1, p1, Status.SCHEDULED, PaymentType.PRIVATE);
        Appointment ap2 = new Appointment(null, d2, p2, Status.COMPLETED, PaymentType.INSURANCE);

        appointmentRepository.saveAll(Arrays.asList(ap1, ap2));
    }
}



