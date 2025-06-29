package io.github.vibondarenko.aimeetingoptimizer.service;

import io.github.vibondarenko.aimeetingoptimizer.DTO.TaskDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AIService {

    private final WebClient webClient = WebClient.create("http://localhost:5000");

    public List<TaskDTO> analyzeTranscript(String transcript) {
        String response = webClient.post()
                .uri("/analyze")
                .bodyValue(transcript)
                .retrieve()
                .bodyToMono(String.class).block();

        //Парсимо JSON у список TaskDTO
        //return parseTasks(response);
        return null;
    }


}
