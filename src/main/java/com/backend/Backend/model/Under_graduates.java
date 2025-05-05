package com.backend.Backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Under_graduates {
    @Id
    private String id;
    private String degree;
    private String university;

    @ManyToMany
    @JoinTable(name="under_graduate_sessions ",
            joinColumns = @JoinColumn(name="under_graduates_id"),
            inverseJoinColumns = @JoinColumn(name="sessions_id"))
    private List<Session> sessions;
}
