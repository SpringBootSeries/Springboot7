package com.backend.Backend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Post_graduates {
    @Id
    private String id;
    private String institute;
    private String research_interest;
    private String second_degree;

    @ManyToMany
    @JoinTable(name = "post_graduate_sessions",
                joinColumns = @JoinColumn(name = "post_graduates_id"),
                 inverseJoinColumns = @JoinColumn(name = "session_id"))

    private List<Session> sessions;



}
