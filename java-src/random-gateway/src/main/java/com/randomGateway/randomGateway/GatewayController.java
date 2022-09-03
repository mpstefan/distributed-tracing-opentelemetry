package com.randomGateway.randomGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;
import java.util.random.RandomGenerator;

@RestController
public class GatewayController {
    Random random = new Random();
    final int maxCharactersToReturn = 15;
    @GetMapping("/randomString")
    public String generateRandomString(){
        int charactersToReturn = random.nextInt(maxCharactersToReturn) + 1;
        String somewhatRandomString = "";

        for(int i = 0; i < charactersToReturn; i++){
            int coinflip = random.nextInt(2);
            if(coinflip == 0){
                somewhatRandomString += "1";
            }else{
                somewhatRandomString += "L";
            }
        }
        return somewhatRandomString;
    }
}
