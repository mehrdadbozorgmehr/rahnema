package com.rehnemacollege.backend.model.exception;

public class EntityNotFoundException extends Exception {

    private final Integer id;

    public EntityNotFoundException(Integer id) {
        super("entity not found");
        this.id = id;
    }

    public Integer getId() {
        return id;
    }
}
