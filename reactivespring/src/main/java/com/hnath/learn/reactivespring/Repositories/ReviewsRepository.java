package com.hnath.learn.reactivespring.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.hnath.learn.reactivespring.model.movies.Reviews;


@Repository
public interface ReviewsRepository extends ReactiveMongoRepository<Reviews, String> {


}
