package com.backend.Backend.model;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public class Person {
    private String email;
    private String gender;
    private String name;
    private int phone;


}
