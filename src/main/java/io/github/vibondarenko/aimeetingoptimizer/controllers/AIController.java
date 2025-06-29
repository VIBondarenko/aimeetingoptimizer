package io.github.vibondarenko.aimeetingoptimizer.controllers;

import io.github.vibondarenko.aimeetingoptimizer.DTO.TaskDTO;
import io.github.vibondarenko.aimeetingoptimizer.service.AIService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/analysis")
public class AIController {
    @Autowired
    private AIService aiService;

    @PostMapping("/tasks")
    public ResponseEntity<List<TaskDTO>> analyze(@RequestBody String transcript) {
        return ResponseEntity.ok(aiService.analyzeTranscript(transcript));
    }
}