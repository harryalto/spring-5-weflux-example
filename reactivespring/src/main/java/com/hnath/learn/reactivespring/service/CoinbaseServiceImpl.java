package com.hnath.learn.reactivespring.service;

import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.hnath.learn.reactivespring.repositories.PurchaseRepository;
import com.hnath.learn.reactivespring.model.CoinBaseResponse;
import com.hnath.learn.reactivespring.model.Purchase;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class CoinbaseServiceImpl  implements  CoinbaseService{

    @Autowired
    private WebClient  webClient;

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    @Autowired
    private PurchaseRepository purchaseRepository;

    @Override
    public Mono<CoinBaseResponse> getCryptoPrice(final String priceName) {
        return webClient
                .get()
                .uri("https://api.coinbase.com/v2/prices/{crypto}/buy", priceName)
                .exchange()
                //.subscribeOn(Schedulers.fromExecutorService( ))
                .flatMap(clientResponse ->
                        clientResponse.bodyToMono(CoinBaseResponse.class));

    }


    @Override
    public Mono<Purchase> createPurchase(final String priceName) {
        return getCryptoPrice(priceName)
                .flatMap(price -> reactiveMongoOperations
                        .save(
                        new Purchase( priceName, price.getData().getAmount(), LocalDateTime.now())));
    }

    @Override
    public Mono<Purchase> getPurchaseById(final String id) {

        return purchaseRepository.findById(id);

    }

    @Override
    public Mono<Void> deleteById(final String Id) {

         return this.purchaseRepository.deleteById(Id);
    }

    @Override
    public Flux<Purchase> listAllPurchases() {

        return reactiveMongoOperations.findAll(Purchase.class);
    }
}
