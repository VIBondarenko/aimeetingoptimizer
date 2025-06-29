package io.github.vibondarenko.aimeetingoptimizer.controllers;

import io.github.vibondarenko.aimeetingoptimizer.service.TeamsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class TeamsController {
    @Autowired
    private TeamsService teamsService;

    @GetMapping("/meetings")
    public ResponseEntity<String> getMeetings(@RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(teamsService.getMeetings(token));
    }
}
