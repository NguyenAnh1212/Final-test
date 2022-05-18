package com.example.test.controller;

import com.example.test.model.City;
import com.example.test.model.Nation;
import com.example.test.service.city.ICitySV;
import com.example.test.service.nation.INationSV;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICitySV citySV;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAll(){
        Iterable<City> cities = citySV.findAll();
        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findbyId(@PathVariable Long id){
        Optional<City> cityOptional = citySV.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(cityOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city){
        return new ResponseEntity<>(citySV.save(city), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> delete(@PathVariable Long id){
       Optional<City> cityOptional = citySV.findById(id);
       if(!cityOptional.isPresent()){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       citySV.remove(id);
       return new ResponseEntity<>(cityOptional.get(), HttpStatus.NO_CONTENT);
    }


}
