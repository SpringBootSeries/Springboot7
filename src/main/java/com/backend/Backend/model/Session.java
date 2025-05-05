package com.backend.Backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

import java.sql.Time;
import java.util.Date;
import java.util.List;

@Entity
public class Session {
    @Id
    private String id;
    private Date date;
    private String description;
    private String name;
    private Time time;
    private int workshop_id;

    @ManyToMany(mappedBy="sessions")
    private List<Post_graduates> post_graduates;

    @ManyToMany(mappedBy="sessions")
    private List<Under_graduates> under_graduates;

    @ManyToMany(mappedBy="sessions")
    private List<Presenter>presenters;
}
