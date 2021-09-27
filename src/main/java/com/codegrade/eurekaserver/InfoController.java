package com.codegrade.eurekaserver;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping(path = "/info")
    public String welcome() {
        return "Hello World";
    }
}