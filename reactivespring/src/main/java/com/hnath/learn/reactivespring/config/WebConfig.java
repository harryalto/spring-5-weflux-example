package com.hnath.learn.reactivespring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.config.EnableWebFlux;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import com.hnath.learn.reactivespring.controller.PurchaseHandler;


@Configuration
@EnableWebFlux
public class WebConfig {

    @Bean
    public PurchaseHandler purchaseHandler(){
        return new PurchaseHandler();
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionPurchase(final PurchaseHandler purchaseHandler){
        return RouterFunctions.route(RequestPredicates.
                GET( "/coin/purchase/v1/{id}").
                and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), purchaseHandler::listPurchases);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunctionAllPurchases( final PurchaseHandler purchaseHandler){

        return RouterFunctions.
                route(
                        RequestPredicates.GET( "/coin/purchase/v1/"),
                        purchaseHandler::listAllPurchases);
    }
}
