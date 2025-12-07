package com.ecommerceSG.MovieRatingSystem.service;

import com.ecommerceSG.MovieRatingSystem.model.Rating;
import com.ecommerceSG.MovieRatingSystem.model.Show;
import com.ecommerceSG.MovieRatingSystem.model.User;
import com.ecommerceSG.MovieRatingSystem.repository.RatingRepository;
import com.ecommerceSG.MovieRatingSystem.repository.ShowRepository;
import com.ecommerceSG.MovieRatingSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;

    public Rating rateShow(Long userId, Long showId, Integer stars) {
        // TODO:
        // 1. fetch user
        // 2. fetch show
        // 3. create rating
        // 4. save rating
        User user = userRepository.findById(userId).get();
        Show show = showRepository.findById(showId).get();
        Rating rating = new Rating();
        rating.setUser(user);
        rating.setShow(show);
        rating.setStars(stars);
        return ratingRepository.save(rating);
    }
}
