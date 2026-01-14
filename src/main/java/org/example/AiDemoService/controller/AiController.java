package org.example.AiDemoService.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.AiDemoService.service.AiService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.example.AiDemoService.dto.*;
@RestController
@RequestMapping("/api/ai")
@RequiredArgsConstructor
public class AiController {

    private final AiService aiService;

    @PostMapping("/chat")
    public ChatResponseDTO chat(@Valid @RequestBody ChatRequestDTO request) {
        return new ChatResponseDTO(aiService.chat(request.getMessage()));
    }

    @PostMapping("/summarize")
    public SummarizeResponseDTO summarize(@Valid @RequestBody SummarizeRequestDTO request) {
        return new SummarizeResponseDTO(aiService.summarize(request.getText()));
    }

}
