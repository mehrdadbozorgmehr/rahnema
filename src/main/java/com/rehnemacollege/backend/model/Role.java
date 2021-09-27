package com.rehnemacollege.backend.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Role implements GrantedAuthority {

    @Id
    private Long id;
    private String authority;

}
