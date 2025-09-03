package com.example.tanvi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController // this is called an annotation. ctrl + space or strl+shift+o to automatically write
public class HomeController {

    @GetMapping("/") // this is an api. this represents an HTTP GET request
    public String home() {
        return "<h1>Welcome to Tanvi's Spring Boot App!</h1>";
    }
}
