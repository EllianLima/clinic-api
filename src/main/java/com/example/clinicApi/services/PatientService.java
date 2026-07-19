package com.example.clinicApi.services;

import com.example.clinicApi.entities.Patient;
import com.example.clinicApi.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository repository;

    public List<Patient> findAll(){
        return repository.findAll();
    }

    public Patient findById(Long id){
        Optional<Patient> obj = repository.findById(id);
        return obj.get();
    }

    public Patient insert(Patient obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        repository.deleteById(id);
    }

    public Patient update(Long id, Patient obj){
        Patient entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    public void updateData(Patient entity, Patient obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
