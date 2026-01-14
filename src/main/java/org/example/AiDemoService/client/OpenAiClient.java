package org.example.AiDemoService.client;

import lombok.RequiredArgsConstructor;
import org.example.AiDemoService.dto.OpenAiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class OpenAiClient {

    @Value("${openai.api-key}")
    private String apiKey;

    @Value("${openai.url}")
    private String url;

    private final WebClient webClient = WebClient.builder().build();

    public String sendPrompt(String prompt) {

        Map<String, Object> request = Map.of(
                "model", "gpt-4o-mini",
                "messages", List.of(
                        Map.of("role", "user", "content", prompt)
                )
        );

        OpenAiResponse response = webClient.post()
                .uri(url)
                .header(HttpHeaders.AUTHORIZATION, "Bearer " + apiKey)
                .header(HttpHeaders.CONTENT_TYPE, "application/json")
                .bodyValue(request)
                .retrieve()
                .bodyToMono(OpenAiResponse.class)
                .block();

        return response.getChoices().get(0).getMessage().getContent();
    }


}

