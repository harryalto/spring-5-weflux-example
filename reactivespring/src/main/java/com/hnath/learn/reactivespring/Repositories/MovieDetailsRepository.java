package com.hnath.learn.reactivespring.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.hnath.learn.reactivespring.model.Movies.Moviedetails;

@Repository
public interface MovieDetailsRepository extends ReactiveMongoRepository<Moviedetails, String> {


}
