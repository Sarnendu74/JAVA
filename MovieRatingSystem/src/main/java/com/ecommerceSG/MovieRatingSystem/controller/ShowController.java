package com.ecommerceSG.MovieRatingSystem.controller;

import com.ecommerceSG.MovieRatingSystem.model.Show;
import com.ecommerceSG.MovieRatingSystem.service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/shows")
public class ShowController {

    @Autowired
    ShowService showService;

    @GetMapping("/getAllShows")
    public Page<Show> getAll(@RequestParam int page,
                             @RequestParam int size) {
        return showService.getShows(PageRequest.of(page,size));
    }

    @PostMapping("/createShow")
    public Show createShow(@RequestBody Show show) {
        return showService.createShow(show);
    }

    @GetMapping("/sorted")
    public List<Show> sorted() {
        return showService.getShowsSortedByTime();
    }
}