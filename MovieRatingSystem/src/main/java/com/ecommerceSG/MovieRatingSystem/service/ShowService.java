package com.ecommerceSG.MovieRatingSystem.service;

import com.ecommerceSG.MovieRatingSystem.model.Show;
import com.ecommerceSG.MovieRatingSystem.repository.ShowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    public Show createShow(Show show) {
        // TODO
        return showRepository.save(show);
    }

    public Page<Show> getShows(Pageable pageable) {
        // TODO
        return  showRepository.findAll(pageable);
    }

    public List<Show> getShowsSortedByTime() {
        // TODO
        return showRepository.findAllByOrderByStartTimeAsc();
    }
}
