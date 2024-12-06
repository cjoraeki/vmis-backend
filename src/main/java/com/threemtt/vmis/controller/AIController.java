//package com.threemtt.vmis.controller;
//
//import com.threemtt.vmis.service.AIService;
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequiredArgsConstructor
//@RequestMapping("/api/ai")
//public class AIController {
//
//    private final AIService aiService;
//
//    @PostMapping("/generate")
//    public String generateText(@RequestBody String prompt) {
//        return aiService.generateText(prompt);
//    }
//}
