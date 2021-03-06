package com.hnath.learn.reactivespring.service.movies;

import com.hnath.learn.reactivespring.model.movies.Moviedetails;
import com.hnath.learn.reactivespring.model.movies.Movies;
import com.hnath.learn.reactivespring.model.movies.Reviews;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface MovieService {
    Flux<Movies> getMovies();

    Mono<Movies> getMovie(String movieId);

    Mono<Moviedetails> getMovieDetails(final String movieId);

    Mono<Reviews> getMovieReviews(final String movieId);

}
