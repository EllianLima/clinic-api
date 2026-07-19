package com.example.clinicApi.services;

import com.example.clinicApi.entities.Specialty;
import com.example.clinicApi.repositories.SpecialtyRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
        return obj.get();
    }
}
