package com.example.hosp_ai_demo;

import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.r7b7.client.IGroqClient;
import com.r7b7.client.model.Message;
import com.r7b7.client.model.OpenAIResponse;
import com.r7b7.entity.CompletionRequest;
import com.r7b7.entity.CompletionResponse;
import com.r7b7.entity.ErrorResponse;

@Service
public class CustomGroqClient implements IGroqClient {
    private final RestTemplate restTemplate;

    public CustomGroqClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public CompletionResponse generateCompletion(CompletionRequest request) {
        CompletionResponse response = null;
        try {
            System.out.println("Inside Custom Groq Client");
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonRequest;

            jsonRequest = objectMapper.writeValueAsString(request.requestBody());

            response = sendPostRequest(request.apiKey(), jsonRequest);
        } catch (JsonProcessingException e) {
            System.out.println(e);
        }
        return response;
    }

    public CompletionResponse sendPostRequest(String apiKey, String reqBody) {
        String url = "https://api.groq.com/openai/v1/chat/completions"; 

        // Set headers if needed
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + apiKey);

        // Wrap the request body and headers in HttpEntity
        HttpEntity<Object> request = new HttpEntity<>(reqBody, headers);

        // Make the POST request
        ResponseEntity<String> response = restTemplate.exchange(
                url,
                HttpMethod.POST,
                request,
                String.class);

        return extractResponseText(response.getBody()); 
    }

    private CompletionResponse extractResponseText(String responseBody) {
        List<Message> msgs = null;
        OpenAIResponse response = null;
        ErrorResponse error = null;

        try {
            ObjectMapper mapper = new ObjectMapper();
            response = mapper.readValue(responseBody, OpenAIResponse.class);
            msgs = response.choices().stream()
                    .map(choice -> new Message(choice.message().role(), choice.message().content())).toList();
        } catch (Exception ex) {
            error = new ErrorResponse("Exception occurred in extracting response", ex);
        }
        return new CompletionResponse(msgs, null, error);
    }
}
