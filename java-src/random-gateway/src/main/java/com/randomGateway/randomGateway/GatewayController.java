package com.randomGateway.randomGateway;

import org.apache.coyote.Request;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Random;

@RestController @Service
public class GatewayController {
    Random random = new Random();
    final int maxCharactersToReturn = 15;

    WebClient randomLettersClient = WebClient.create("http://localhost:8081");
    WebClient.UriSpec<WebClient.RequestBodySpec> letterUriSpec = (WebClient.UriSpec<WebClient.RequestBodySpec>) randomLettersClient.get();
    WebClient.RequestBodySpec letterBodySpec = letterUriSpec.uri("/randomLetter");

    WebClient randomNumbersClient = WebClient.create("http://localhost:8082");
    WebClient.UriSpec<WebClient.RequestBodySpec> numberUriSpec = (WebClient.UriSpec<WebClient.RequestBodySpec>) randomNumbersClient.get();
    WebClient.RequestBodySpec numberBodySpec = numberUriSpec.uri("/randomNumber");



    @GetMapping("/randomString")
    public String generateRandomString(){
        int charactersToReturn = random.nextInt(maxCharactersToReturn) + 1;
        String somewhatRandomString = "";



        for(int i = 0; i < charactersToReturn; i++){
            int coinFlip = random.nextInt(2);
            if(coinFlip == 0){
                somewhatRandomString += getRandomLetter();
            }else{
                somewhatRandomString += getRandomNumber();
            }
        }
        return somewhatRandomString;
    }

    public String getRandomLetter(){
        WebClient.ResponseSpec apiResponse = letterBodySpec.retrieve();
        return apiResponse.bodyToMono(String.class).block();
    }

    public String getRandomNumber(){
        WebClient.ResponseSpec apiResponse = numberBodySpec.retrieve();
        return apiResponse.bodyToMono(String.class).block();
    }
}
