package com.backend.Backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Presenter {
    @Id
    private String id;
    private String affiliation;
    private String country;
    private String ob_title;

    @ManyToMany
    @JoinTable(name = "presenter_sessions",
                joinColumns = @JoinColumn(name = "presenter_id"),
    inverseJoinColumns = @JoinColumn(name = "sessions_id"))

    private List<Session>sessions;
    g

}
