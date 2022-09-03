package com.randomNumbers.randomNumbers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class RandomNumberController {

    Random random = new Random();
    @GetMapping("/randomNumber")
    public String generateRandomString(){

        return Integer.toString(random.nextInt(10));
    }
}
