package com.ecommerceSG.MovieRatingSystem.controller;

import com.ecommerceSG.MovieRatingSystem.model.Rating;
import com.ecommerceSG.MovieRatingSystem.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ratings")
public class RatingController {

    @Autowired
    RatingService ratingService;

    @PostMapping("/set")
    public Rating rate(@RequestParam Long userId,
                       @RequestParam Long showId,
                       @RequestParam Integer stars) {
        // TODO
        return ratingService.rateShow(userId, showId, stars);
    }
}