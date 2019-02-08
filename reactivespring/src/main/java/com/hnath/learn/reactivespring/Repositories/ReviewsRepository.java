package com.hnath.learn.reactivespring.Repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.hnath.learn.reactivespring.model.Movies.Moviedetails;
import com.hnath.learn.reactivespring.model.Movies.Reviews;


@Repository
public interface ReviewsRepository extends ReactiveMongoRepository<Reviews, String> {


}
