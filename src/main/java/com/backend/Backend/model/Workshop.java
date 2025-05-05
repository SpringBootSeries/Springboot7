package com.backend.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.Date;

@Entity
public class Workshop {
    @Id
    private String id;
    private String description;
    private Date end_date;
    private String name;
    private Date start_date;
}
