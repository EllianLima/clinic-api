package com.example.clinicApi.resources;

import com.example.clinicApi.entities.Specialty;
import com.example.clinicApi.services.SpecialtyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/Specialtys")
public class SpecialtyResource {
    
    @Autowired
    private SpecialtyService service;
    
    @GetMapping
    public ResponseEntity<List<Specialty>> findALl(){
        List<Specialty> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Specialty> findById(@PathVariable Long id){
        Specialty obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Specialty> insert(@RequestBody Specialty obj){
       obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }
    
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id){
         service.delete(id);
         return ResponseEntity.noContent().build();
         
    }

    
}
