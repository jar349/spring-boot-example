package com.johnruiz.examples.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jar349 on 1/23/15.
 */
@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String getHello() {
        return "Greetings from Spring Boot!\n";
    }
}
