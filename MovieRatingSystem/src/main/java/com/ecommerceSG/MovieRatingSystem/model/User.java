package com.ecommerceSG.MovieRatingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ✅ Getters & Setters
    @Getter
    @Setter
    private Long id;
    @Setter
    @Getter
    private String username;
    @Getter
    @Setter
    private String password;
    @Setter
    @Getter
    private String role;


    @OneToMany(mappedBy = "user")
    private List<Rating> ratings;

    // ✅ No-arg constructor (REQUIRED for JPA)
    public User() {
    }

    // ✅ All-args constructor
    public User(Long id, String username, String password, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
    }

}
