package com.hnath.learn.reactivespring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveSpringApplication.class, args);
	}

}

/*
How to run

curl -X POST 'http://localhost:8080/coin/purchase/v1/BTC-USD'
curl -X GET 'http://localhost:8080/coin/purchase/v1/'
curl -X GET 'http://localhost:8080/coin/purchase/v1/{id}'

Prerequisites
1. Install docker before running the command below.Refer to this link --> https://docs.docker
.com/docker-for-mac/install/ for installing on mac.
2. CoinMarketCap requires API KEY to access its API. Please make sure to get one before running this example. Refer
to this link for further details --> https://pro.coinmarketcap.com/signup?plan=0

3. Once docker is installed, make sure to start Mongo DB.

 $ docker run -p 27017:27017 bitnami/mongodb:latest

4. Run the Application with the API key as runtime argument. You dont want to hardcode in the code :-)
   --api_key_value=YOUR KEY VALUE

 */
