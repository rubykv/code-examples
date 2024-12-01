package com.example.hosp_ai_demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.r7b7.entity.CompletionResponse;
import com.r7b7.entity.Provider;
import com.r7b7.service.LLMService;
import com.r7b7.service.LLMServiceFactory;
import com.r7b7.service.PromptEngine;

@RestController
public class GreetingsResource {
    
    @GetMapping("/greetings")
    public String getGreetings(){
        return "Hello Visitor!";
    }

    @GetMapping("/prompt")
    public CompletionResponse getChatCompletion(@RequestParam String query){

        LLMService service = LLMServiceFactory.createService(Provider.GROQ, "<YOUR_GROQ_API_KEY>", "mixtral-8x7b-32768");
        PromptEngine promptEngine = new PromptEngine(service);
        CompletionResponse response = promptEngine.getResponse(query);

        return response;
    }
}
