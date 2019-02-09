package com.hnath.learn.reactivespring.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.hnath.learn.reactivespring.model.movies.Moviedetails;

@Repository
public interface MovieDetailsRepository extends ReactiveMongoRepository<Moviedetails, String> {


}
