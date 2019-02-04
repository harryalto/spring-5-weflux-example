package com.hnath.learn.reactivespring.controller;

import java.util.concurrent.atomic.AtomicInteger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hnath.learn.reactivespring.model.Purchase;
import com.hnath.learn.reactivespring.service.CoinbaseService;
import com.hnath.learn.reactivespring.service.coinmarketcap.CoinMarketCapService;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping("/coin/purchase/v1")
public class PurchaseController {

    private static AtomicInteger atomicInteger = new AtomicInteger(0);

    @Autowired
    private CoinbaseService coinbaseService;

    @Autowired
    private CoinMarketCapService coinMarketCapService;

    @PostMapping(value = "/{name}")
    public Mono<Purchase> createPurchase(@PathVariable("name") String name) {
        // Simple way to alternate between the Service Impls

        if (atomicInteger.incrementAndGet() % 2 == 0) {
            return coinbaseService.createPurchase(name);
        } else {
            return coinMarketCapService.createPurchase(name);
        }

    }

}
