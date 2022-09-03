package com.randomGateway.randomGateway;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GatewayController {

    @GetMapping("/randomString")
    public String generateRandomString(){
        return "This is absolutely not random";
    }
}
