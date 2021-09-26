package com.rehnemacollege.backend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

@Data
@NoArgsConstructor
public class Car {

    @NonNull
    private Integer id;
    private String name;
    private String company;

}
