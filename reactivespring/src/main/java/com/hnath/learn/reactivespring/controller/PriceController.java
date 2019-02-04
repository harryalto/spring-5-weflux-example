package com.hnath.learn.reactivespring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hnath.learn.reactivespring.model.CoinBaseResponse;
import com.hnath.learn.reactivespring.service.CoinbaseService;
import reactor.core.publisher.Mono;


@RestController
@RequestMapping( "/coin/price/v1")
public class PriceController {

    @Autowired
    private CoinbaseService coinbaseService;

    //TODO Change String to Domain Model type when ready
    @GetMapping( value= "/{name}")
    public Mono<CoinBaseResponse> getPrice(@PathVariable String name){
        System.out.println(" Input :" + name);
        return coinbaseService.getCryptoPrice(name);

    }

    @DeleteMapping( value= "/{name}")
    public Mono<Void> deleteById( @PathVariable String name){
        System.out.println(name);
        return coinbaseService.deleteById(name);


    }
}
