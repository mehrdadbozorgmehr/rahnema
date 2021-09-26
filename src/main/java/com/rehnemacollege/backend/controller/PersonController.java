package com.rehnemacollege.backend.controller;

import com.rehnemacollege.backend.model.Person;
import com.rehnemacollege.backend.model.Person;
import com.rehnemacollege.backend.model.exception.EntityNotFoundException;
import com.rehnemacollege.backend.repository.PersonRepository;
import com.rehnemacollege.backend.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repo;

    @Autowired
    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/get")
    public Iterable<Person> all(@RequestParam(name = "page", defaultValue = "0") int page,
                                @RequestParam(name = "size", defaultValue = "10") int size) {
        Pageable pageable = Pageable.ofSize(size).withPage(page);
        return repo.findAll(pageable);
    }

    @GetMapping("/search")
    public Iterable<Person> all(@RequestParam("query") String query) {
        return repo.findByNameContaining(query);
    }

    @GetMapping("/get/{id}")
    public Person get(@PathVariable("id") Long id) throws EntityNotFoundException {
        Optional<Person> person = repo.findById(id);
        if (person.isPresent()) {
            return person.get();
        }
        throw new EntityNotFoundException(id);
    }

    @PostMapping("/add")
    public void add(@Validated @RequestBody Person person) {
        repo.save(person);
    }

    @PutMapping("/edit/{id}")
    public void update(@PathVariable("id") Long id, @RequestBody Person person) throws EntityNotFoundException {
        Optional<Person> existing = repo.findById(id);
        if(existing.isPresent()) {
            person.setId(id);
            repo.save(person);
            return;
        }
        throw new EntityNotFoundException(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id) throws EntityNotFoundException {
        Optional<Person> person = repo.findById(id);
        if(person.isPresent()) {
            repo.delete(person.get());
            return;
        }
        throw new EntityNotFoundException(id);
    }



}
