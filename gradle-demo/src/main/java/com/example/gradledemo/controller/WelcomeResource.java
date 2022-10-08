package com.example.gradledemo.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class WelcomeResource {

    @GetMapping(value="greetings", produces = MediaType.APPLICATION_JSON_VALUE )
    public String greetings(){
        return "Welcome Girl!";
    }
}
