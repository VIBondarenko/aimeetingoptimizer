package io.github.vibondarenko.aimeetingoptimizer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class TeamsService {

    private final WebClient webClient = WebClient.create("https://graph.microsoft.com/v1.0");

    public String getMeetings(String token) {
        return webClient.get()
                .uri("/me/onlineMeetings")
                .header("Authorization", "Bearer " + token)
                .retrieve()
                .bodyToMono(String.class).block();
    }

    public byte[] getMeetingRecording(String meetingId, String token) {
        return webClient.get()
                .uri("/me/onlineMeetings/" + meetingId + "/recording")
                .header("Authorization", "Bearer " + token)
                .retrieve().bodyToMono(byte[].class).block();
    }
}
