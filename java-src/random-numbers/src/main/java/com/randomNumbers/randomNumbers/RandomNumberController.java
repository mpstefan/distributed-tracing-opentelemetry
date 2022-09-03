package com.randomNumbers.randomNumbers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomNumberController {

    @GetMapping("/randomNumber")
    public String generateRandomString(){
        return "1";
    }
}
