package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, String> {
}
