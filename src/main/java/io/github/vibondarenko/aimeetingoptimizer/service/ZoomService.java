package io.github.vibondarenko.aimeetingoptimizer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ZoomService {

    private final WebClient webClient = WebClient.create("https://api.zoom.us/v2");

    public String getRecordings(String userId, String token) {
        return webClient.get()
                .uri("/users/" + userId + "/recordings")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class).block();
    }

    public byte[] downloadRecording(String downloadUrl, String token) {
        return webClient.get()
                .uri(downloadUrl)
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
    }
}
