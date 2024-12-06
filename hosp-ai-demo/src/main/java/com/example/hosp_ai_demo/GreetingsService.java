package com.example.hosp_ai_demo;

import org.springframework.stereotype.Service;

import com.r7b7.client.factory.LLMClientFactory;
import com.r7b7.entity.CompletionResponse;
import com.r7b7.entity.Provider;
import com.r7b7.service.ILLMService;
import com.r7b7.service.LLMServiceFactory;
import com.r7b7.service.PromptEngine;

@Service
public class GreetingsService {

    private CustomGroqClient customGroqClient;

    public CompletionResponse getChatCompletion(String query) {
        LLMClientFactory.setGroqClient(customGroqClient);
        ILLMService service = LLMServiceFactory.createService(Provider.GROQ, "<GROK_API_KEY>", "mixtral-8x7b-32768");
        PromptEngine promptEngine = new PromptEngine(service);
        CompletionResponse response = promptEngine.sendQuery(query);
        return response;
    }

    public GreetingsService(CustomGroqClient customGroqClient) {
        this.customGroqClient = customGroqClient;
    }

}
