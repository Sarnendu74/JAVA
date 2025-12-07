package com.ecommerceSG.MovieRatingSystem.repository;

import com.ecommerceSG.MovieRatingSystem.model.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating,Long> {
}
