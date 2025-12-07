package com.ecommerceSG.MovieRatingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@Entity
@Table(name = "show")
public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // ✅ Getters & Setters
    private Long id;
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

    // optional relationship
    @OneToMany(mappedBy = "show")
     private List<Rating> ratings;

    // ✅ No-arg constructor
    public Show() {
    }

    // ✅ Constructor used in tests
    public Show(Long id, String title, LocalTime startTime, LocalTime endTime) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    // ✅ Full constructor (optional)
    public Show(Long id, String title,
                LocalTime startTime, LocalTime endTime, List<Rating> ratings) {
        this.id = id;
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        // this.ratings = ratings;
    }

}