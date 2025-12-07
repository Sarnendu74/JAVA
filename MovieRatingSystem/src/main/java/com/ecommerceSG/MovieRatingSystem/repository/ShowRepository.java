package com.ecommerceSG.MovieRatingSystem.repository;

import com.ecommerceSG.MovieRatingSystem.model.Show;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ShowRepository extends JpaRepository<Show,Long> {

    List<Show> findAllByOrderByStartTimeAsc();
    List<Show> findByTitleContainingIgnoreCase(String title);
    Page<Show> findAll(Pageable pageable);
}
