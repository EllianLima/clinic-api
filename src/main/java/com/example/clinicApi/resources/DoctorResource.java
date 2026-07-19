package com.example.clinicApi.resources;

import com.example.clinicApi.entities.Doctor;
import com.example.clinicApi.services.DoctorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/doctors")
public class DoctorResource {
    
    @Autowired
    private DoctorService service;
    
    @GetMapping
    public ResponseEntity<List<Doctor>> findALl(){
        List<Doctor> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }
    
    @GetMapping(value = "/{id}")
    public ResponseEntity<Doctor> findById(@PathVariable Long id){
        Doctor obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<Doctor> insert(@RequestBody Doctor obj){
       obj = service.insert(obj);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
         service.delete(id);
         return ResponseEntity.noContent().build();

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Doctor> update(@PathVariable Long id, Doctor obj){
        obj = service.update(id, obj);
        return ResponseEntity.ok().body(obj);
    }


}
