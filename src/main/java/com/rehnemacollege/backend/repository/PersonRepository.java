package com.rehnemacollege.backend.repository;

import com.rehnemacollege.backend.model.Person;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Collection;

public interface PersonRepository extends PagingAndSortingRepository<Person, Long> {

    Collection<Person> findByNameContaining(String name);

}
