package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Car;
import com.rehnemacollege.backend.model.exception.EntityNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class CarRepositoryImpl implements CarRepository {

    private final static Map<Integer, Car> repo = new HashMap<>();

    public void addOrUpdate(Car car) {
        repo.put(car.getId(), car);
    }

    public void delete(Integer id) {
        repo.remove(id);
    }

    public Car get(Integer id) throws EntityNotFoundException {
        if(!repo.containsKey(id)) {
            throw new EntityNotFoundException(id);
        }
        return repo.get(id);
    }

    public Collection<Car> all() {
        return repo.values();
    }
}
