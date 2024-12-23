package com.example.aisample.controller;

import org.springframework.ai.chat.ChatClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AiController {
    private final ChatClient chatClient;

    public AiController(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @GetMapping("/ai/message")
    public String getMessage(@RequestParam(value = "prompt") String prompt) {
        int a = 10;
        int b = 10;
        int x = a /b;
        return chatClient.generate(prompt);

    }

}
