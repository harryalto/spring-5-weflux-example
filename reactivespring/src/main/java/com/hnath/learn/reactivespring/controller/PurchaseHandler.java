package com.hnath.learn.reactivespring.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.hnath.learn.reactivespring.model.Purchase;
import com.hnath.learn.reactivespring.service.CoinbaseService;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public class PurchaseHandler {

    @Autowired
    private CoinbaseService coinbaseService;

    public Mono<ServerResponse> listPurchases(ServerRequest serverRequest) {

      //  final Mono<Purchase> purchaseMono = Mono.fromSupplier(
      //          () -> new Purchase( "From Functional Endpoint", "123",
      //                  LocalDateTime.now()));

        final Mono<Purchase> purchaseMono = coinbaseService.getPurchaseById( serverRequest.pathVariable("id"));
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(purchaseMono, Purchase.class);


    }

    public Mono<ServerResponse> listAllPurchases( ServerRequest serverRequest){

        final Flux<Purchase> purchaseFlux = coinbaseService.listAllPurchases();
        return  ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(purchaseFlux.collectList(),
                        new ParameterizedTypeReference<List<Purchase>>() {}
                );
    }
}
