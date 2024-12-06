package com.example.hosp_ai_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r7b7.entity.CompletionResponse;

@RestController
public class GreetingsResource {
    private GreetingsService greetingsService;

    @GetMapping("/greetings")
    public String getGreetings() {
        return "Hello Visitor!";
    }

    @GetMapping("/prompt")
    public CompletionResponse getChatCompletion(@RequestParam String query) {
        var response = greetingsService.getChatCompletion(query);
        return response;
    }

    public GreetingsResource(GreetingsService greetingsService) {
        this.greetingsService = greetingsService;
    }
}
