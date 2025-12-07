package com.ecommerceSG.MovieRatingSystem.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "rating")
public class Rating {

    // ✅ Getters & Setters
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "show_id")
    private Show show;
    private Integer stars;

    // ✅ No-arg constructor
    public Rating() {
    }

    // ✅ All-args constructor (USED IN TESTS)
    public Rating(Long id, User user, Show show, Integer stars) {
        this.id = id;
        this.user = user;
        this.show = show;
        this.stars = stars;
    }

}
