package org.example.AiDemoService.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.AiDemoService.client.OpenAiClient;
import org.example.AiDemoService.service.AiService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OpenAiServiceImpl implements AiService {

    private final OpenAiClient openAiClient;

    @Override
    public String chat(String message) {
        return openAiClient.sendPrompt(message);
    }

    @Override
    public String summarize(String text) {
        String prompt = "Summarize the following text:\n" + text;
        return openAiClient.sendPrompt(prompt);
    }

}
