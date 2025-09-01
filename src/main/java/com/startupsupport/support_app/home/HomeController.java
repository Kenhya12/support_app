package com.startupsupport.support_app.home;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class HomeController {
    @GetMapping("/")
    public String home() {
        return "Welcome to the Support App!";
    }
}