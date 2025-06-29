package io.github.vibondarenko.aimeetingoptimizer.controllers;

import io.github.vibondarenko.aimeetingoptimizer.DTO.TaskDTO;
import io.github.vibondarenko.aimeetingoptimizer.service.JiraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/jira")
public class JiraController {
    @Autowired
    private JiraService jiraService;

    @PostMapping("/create-task")
    public ResponseEntity<String> createTaskInJira(@RequestBody TaskDTO taskDTO) {
        jiraService.createTask(taskDTO);
        return ResponseEntity.ok("Task created in Jira successfully");
    }
}
