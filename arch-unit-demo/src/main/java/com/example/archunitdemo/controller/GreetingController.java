package com.example.archunitdemo.controller;

import com.example.archunitdemo.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @Autowired
    private GreetingService greetingService;

    @GetMapping("/greetings")
    public ResponseEntity<String> getGreetings() {
        return new ResponseEntity(greetingService.getGreetings(), HttpStatus.OK);
    }
}
