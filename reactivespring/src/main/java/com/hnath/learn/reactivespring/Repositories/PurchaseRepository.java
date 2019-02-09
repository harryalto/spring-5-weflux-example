package com.hnath.learn.reactivespring.repositories;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import com.hnath.learn.reactivespring.model.Purchase;

@Repository
public interface PurchaseRepository extends ReactiveMongoRepository<Purchase, String> {



}
