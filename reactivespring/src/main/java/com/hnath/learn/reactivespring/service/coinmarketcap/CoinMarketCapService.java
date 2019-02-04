package com.hnath.learn.reactivespring.service.coinmarketcap;

import com.hnath.learn.reactivespring.model.CoinMarketCap.CoinMarketCapResponse;
import com.hnath.learn.reactivespring.model.Purchase;
import reactor.core.publisher.Mono;


public interface CoinMarketCapService {

     Mono<String> getCryptoPrice(final String priceName);

     Mono<Purchase> createPurchase( String priceName);


}
