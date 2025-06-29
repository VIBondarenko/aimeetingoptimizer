package io.github.vibondarenko.aimeetingoptimizer.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class GoogleMeetService {

    private final WebClient webClient = WebClient.create("https://www.googleapis.com");

    public String getMeetings(String accessToken) {
        return webClient.get()
                .uri("/calendar/v3/calendars/primary/events")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve().bodyToMono(String.class).block();
    }

    public byte[] downloadRecording(String fileId, String accessToken) {
        return webClient.get()
                .uri("/drive/v3/files/" + fileId + "?alt=media")
                .header("Authorization", "Bearer " + accessToken)
                .retrieve()
                .bodyToMono(byte[].class)
                .block();
    }
}
