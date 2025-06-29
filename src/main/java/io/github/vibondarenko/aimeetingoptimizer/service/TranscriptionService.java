package io.github.vibondarenko.aimeetingoptimizer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TranscriptionService {

    private final WebClient webClient = WebClient.create("http://localhost:5000");

    public String transcribeAudio(byte[] audioFile) {
        return webClient.post()
                .uri("/transcribe")
                .bodyValue(audioFile)
                .retrieve()
                .bodyToMono(String.class).block();
    }
}
