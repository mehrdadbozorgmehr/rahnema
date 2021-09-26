package com.rehnemacollege.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post {

    @Id
    private Long id;

    @Column(name = "creation_date", nullable = true, unique = false)
    private Date createdAt;
    private String title;
    private String description;

    @ManyToOne
    private Person author;

}
