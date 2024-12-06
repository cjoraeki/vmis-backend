//package com.threemtt.vmis.service;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class AIService {
////    @Autowired
//    private final OpenAIClient openAIClient;
//
//    public String generateText(String prompt) {
//        // Create a request object for the AI model
//        CompletionRequest request = new CompletionRequest();
//        request.setPrompt(prompt);
//        request.setMaxTokens(100); // Limit the response to 100 tokens
//
//        // Call the OpenAI model and return the result
//        return openAIClient.createCompletion(request).getChoices().get(0).getText();
//    }
//}
