package com.example.archunitdemo.service;

import com.example.archunitdemo.repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GreetingService {

    @Autowired
    private GreetingRepository greetingRepository;
    public String getGreetings() {
        greetingRepository.sampleMethod();
        return "Hello Visitor!";
    }
}
