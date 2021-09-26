package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Car;
import com.rehnemacollege.backend.model.exception.EntityNotFoundException;

import java.util.Collection;

public interface CarRepository {

    void addOrUpdate(Car car);
    Car get(Integer id) throws EntityNotFoundException;
    void delete(Integer id);
    Collection<Car> all();

}
