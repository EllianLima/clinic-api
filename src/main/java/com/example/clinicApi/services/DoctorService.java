package com.example.clinicApi.services;

import com.example.clinicApi.entities.Doctor;
import com.example.clinicApi.repositories.DoctorRepository;
import com.example.clinicApi.services.exceptions.DatabaseException;
import com.example.clinicApi.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepository repository;

    public List<Doctor> findAll(){
        return repository.findAll();
    }

    public Doctor findById(Long id){
        Optional<Doctor> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Doctor insert(Doctor obj){
        return repository.save(obj);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }catch (DataIntegrityViolationException e){
            throw new DatabaseException(e.getMessage());
        }
    }

    public Doctor update(Long id, Doctor obj) {
        try {
            Doctor entity = repository.getReferenceById(id);
            updateData(entity, obj);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new ResourceNotFoundException(id);
        }
    }

    public void updateData(Doctor entity, Doctor obj){
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
        entity.setSpecialty(obj.getSpecialty());
    }
}
