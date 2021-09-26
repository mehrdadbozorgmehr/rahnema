package com.rehnemacollege.backend.controller;

import com.rehnemacollege.backend.model.Car;
import com.rehnemacollege.backend.model.exception.EntityNotFoundException;
import com.rehnemacollege.backend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/car")
public class CarController {

    private final CarRepository repo;

    @Autowired
    public CarController(CarRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/get")
    public Collection<Car> all() {
        return repo.all();
    }

    @GetMapping("/get/{id}")
    public Car get(@PathVariable("id") Integer id) throws EntityNotFoundException {
        return repo.get(id);
    }

    @PostMapping("/add")
    public void add(@Validated @RequestBody Car car) {
        repo.addOrUpdate(car);
    }

    @PutMapping("/edit/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody Car car) {
        repo.addOrUpdate(car);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        repo.delete(id);
    }

}
