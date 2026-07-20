package com.example.clinicApi.services;

import com.example.clinicApi.entities.Specialty;
import com.example.clinicApi.repositories.SpecialtyRepository;
import com.example.clinicApi.services.exceptions.DatabaseException;
import com.example.clinicApi.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpecialtyService {

    @Autowired
    private SpecialtyRepository repository;

    public List<Specialty> findAll(){
        return repository.findAll();
    }

    public Specialty findById(Long id){
        Optional<Specialty> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public Specialty insert(Specialty obj){
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
}
