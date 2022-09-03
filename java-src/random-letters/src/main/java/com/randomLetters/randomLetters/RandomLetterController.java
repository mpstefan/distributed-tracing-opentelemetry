package com.randomLetters.randomLetters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RandomLetterController {

    @GetMapping("/randomLetter")
    public String generateRandomString(){
        return "L";
    }
}
