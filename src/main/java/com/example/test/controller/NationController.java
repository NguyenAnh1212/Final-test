package com.example.test.controller;

import com.example.test.model.Nation;
import com.example.test.service.nation.INationSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/nation")
@CrossOrigin("*")
public class NationController {
    @Autowired
    private INationSV nationSV;

    @GetMapping
    public ResponseEntity<Iterable<Nation>> findAll(){
        Iterable<Nation> nations = nationSV.findAll();
        return new ResponseEntity<>(nations, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Nation> findbyId(@PathVariable Long id){
        Optional<Nation> nationOptional = nationSV.findById(id);
        if (!nationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(nationOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Nation> saveNation(@RequestBody Nation nation){
        return new ResponseEntity<>(nationSV.save(nation), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Nation> delete(@PathVariable Long id){
       Nation nation = nationSV.findById(id).get();
        if (nation!= null) nationSV.remove(id);
        return new ResponseEntity<>(nation, HttpStatus.OK);
    }


}
