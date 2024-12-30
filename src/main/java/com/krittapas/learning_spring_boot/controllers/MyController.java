package com.krittapas.learning_spring_boot.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/")
    public String myController() {
        return "index.html";
    }

    @GetMapping("/home")
    public String home(){
        return "You at Home Now!";
    }

    @GetMapping("/test-api")
    public String testAPI(){
        return "API is working!";
    }
}
