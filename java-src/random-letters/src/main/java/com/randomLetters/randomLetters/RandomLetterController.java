package com.randomLetters.randomLetters;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Random;

@RestController
public class RandomLetterController {

    String[] allLetters = new String[]{"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"};
    Random random = new Random();

    @GetMapping("/randomLetter")
    public String generateRandomString(){
        int indexOfLetterToReturn = random.nextInt(52);
        return allLetters[indexOfLetterToReturn];
    }
}
