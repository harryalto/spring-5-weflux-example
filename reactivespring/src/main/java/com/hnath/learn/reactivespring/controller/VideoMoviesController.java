package com.hnath.learn.reactivespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hnath.learn.reactivespring.model.movies.Moviedetails;
import com.hnath.learn.reactivespring.model.movies.Movies;
import com.hnath.learn.reactivespring.model.movies.Reviews;
import com.hnath.learn.reactivespring.service.movies.MovieService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("v1/movies/")
public class VideoMoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/{name}")
    public Mono<Movies> getMovieById(@PathVariable("name") String name) {
        return movieService.getMovie(name);

    }

    @GetMapping()
    public Flux<Movies> getMovies() {
        return movieService.getMovies();

    }

    @GetMapping(value = "/{name}/details")
    public Mono<Moviedetails> getMovieDetailsById(@PathVariable("name") String name) {
        return movieService.getMovieDetails(name);

    }

    @GetMapping(value = "/{name}/reviews")
    public Mono<Reviews> getMovieReviewsById(@PathVariable("name") String name) {
        return movieService.getMovieReviews(name);

    }

}
