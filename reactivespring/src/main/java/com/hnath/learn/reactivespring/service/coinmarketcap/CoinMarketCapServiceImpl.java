package com.hnath.learn.reactivespring.service.coinmarketcap;

import java.nio.charset.Charset;
import java.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import com.hnath.learn.reactivespring.model.Purchase;
import com.jayway.jsonpath.JsonPath;
import reactor.core.publisher.Mono;
import org.springframework.beans.factory.annotation.Value;


@Service
public class CoinMarketCapServiceImpl implements CoinMarketCapService {

    final private static String API_KEY = "X-CMC_PRO_API_KEY";
    final private static String PARAM_SYMBOL = "symbol";
    final private static String PARAM_CONVERT = "convert";


    @Value( "${api_key_value}")
    private String apiKey;

    @Autowired
    private WebClient webClient;

    @Autowired
    private ReactiveMongoOperations reactiveMongoOperations;

    @Override public Mono<String> getCryptoPrice(final String priceName) {
        final String[] splitSymbolAndCurrency = priceName.split("-");
        if (splitSymbolAndCurrency.length > 0 && splitSymbolAndCurrency.length == 2) {
            System.out.println("API_KEY_VALUE[" + apiKey + "]" );

            return webClient
                    .get()
                    .uri(
                            uriBuilder -> uriBuilder.scheme("https")
                                    .host("pro-api.coinmarketcap.com")
                                    .path("/v1/cryptocurrency/quotes/latest")
                                    .queryParam(PARAM_SYMBOL, splitSymbolAndCurrency[0])
                                    .queryParam(PARAM_CONVERT, splitSymbolAndCurrency[1])
                                    .build()
                    )
                    .header(API_KEY, apiKey)
                    .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                    .accept(MediaType.APPLICATION_JSON)
                    .acceptCharset(Charset.forName("UTF-8"))
                    .exchange()
                    .flatMap(clientResponse ->
                            clientResponse.bodyToMono(String.class))
                    .flatMap(jsonString ->
                            Mono.just(Double.toString(JsonPath.parse(jsonString)
                                    .read("$.data." + splitSymbolAndCurrency[0] + ".quote." + splitSymbolAndCurrency[1]
                                            + ".price")))
                    ).log();
        } else {
            return null;
        }
    }

    @Override
    public Mono<Purchase> createPurchase(final String priceName) {
        System.out.println();
        return getCryptoPrice(priceName)
                .log(" Log")
                .flatMap(price ->

                        reactiveMongoOperations.save(
                                new Purchase(priceName, price,
                                        LocalDateTime.now()))
                );
    }

}


