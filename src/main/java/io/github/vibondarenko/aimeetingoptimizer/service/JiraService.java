package io.github.vibondarenko.aimeetingoptimizer.service;

import io.github.vibondarenko.aimeetingoptimizer.DTO.TaskDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class JiraService {

    private final WebClient webClient;
    private final String url;
    private final String token;

    public JiraService(@Value("${planners.jira.url}") String url, @Value("${planners.jira.token}") String token) {
        this.url = url;
        this.token = token;
        this.webClient = WebClient.create(url);
    }

    public void createTask(TaskDTO task) {
        webClient.post()
                .uri("/rest/api/2/issue")
                .header("Authorization", token)
                .bodyValue(task)
                .retrieve().bodyToMono(String.class).block();
    }
}