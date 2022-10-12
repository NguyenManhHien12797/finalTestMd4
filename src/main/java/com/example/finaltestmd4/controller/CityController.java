package com.example.finaltestmd4.controller;

import com.example.finaltestmd4.model.City;
import com.example.finaltestmd4.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/city")
@CrossOrigin("*")
public class CityController {
    @Autowired
    private ICityService cityService;

    @GetMapping
    public ResponseEntity<Iterable<City>> findAllCity(Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable);
        if (cities.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }


        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<City> findPostById(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        if (!city.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<City> saveCity(@RequestBody City city) {
        return new ResponseEntity<>(  cityService.save(city),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable Long id, @RequestBody City city) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        city.setId(cityOptional.get().getId());
        return new ResponseEntity<>(cityService.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<City> deleteCity(@PathVariable Long id) {
        Optional<City> cityOptional = cityService.findById(id);
        if (!cityOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        cityService.remove(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
