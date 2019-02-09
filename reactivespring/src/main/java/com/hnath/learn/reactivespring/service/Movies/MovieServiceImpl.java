package com.hnath.learn.reactivespring.service.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.hnath.learn.reactivespring.repositories.MovieDetailsRepository;
import com.hnath.learn.reactivespring.repositories.MoviesRepository;
import com.hnath.learn.reactivespring.repositories.ReviewsRepository;
import com.hnath.learn.reactivespring.model.movies.Moviedetails;
import com.hnath.learn.reactivespring.model.movies.Movies;
import com.hnath.learn.reactivespring.model.movies.Reviews;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



@Service
public class MovieServiceImpl  implements MovieService {


    @Autowired
    private MoviesRepository moviesRepository;

    @Autowired
    private MovieDetailsRepository movieDetailsRepository;

    @Autowired
    private ReviewsRepository reviewsRepository;

    @Override public Flux<Movies> getMovies() {

        return moviesRepository.findAll() ;
    }

    @Override public Mono<Movies> getMovie(final String movieId) {

        return moviesRepository.findById(movieId);
    }

    @Override
    public Mono<Moviedetails> getMovieDetails( final String movieId){
        return movieDetailsRepository.findById(movieId);
    }

    @Override
    public Mono<Reviews> getMovieReviews( final String movieId){
        return reviewsRepository.findById(movieId);
    }



}
