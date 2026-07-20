package com.example.clinicApi.services;

import com.example.clinicApi.entities.Appointment;
import com.example.clinicApi.repositories.AppointmentRepository;
import com.example.clinicApi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    @Autowired
    private AppointmentRepository repository;

    public List<Appointment> findAll(){
        return repository.findAll();
    }

    public Appointment findById(Long id){
        Optional<Appointment> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Appointment insert(Appointment obj){
        return repository.save(obj);
    }
}
