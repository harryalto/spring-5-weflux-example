package com.hnath.learn.reactivespring.service;

import com.hnath.learn.reactivespring.model.CoinBaseResponse;
import com.hnath.learn.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface CoinbaseService {

    Mono<CoinBaseResponse>  getCryptoPrice(String priceName);

    Mono<Purchase> createPurchase( String priceName);

    Mono<Purchase> getPurchaseById( String Id);

    Flux<Purchase> listAllPurchases();

    Mono<Void> deleteById( final String Id);
}
