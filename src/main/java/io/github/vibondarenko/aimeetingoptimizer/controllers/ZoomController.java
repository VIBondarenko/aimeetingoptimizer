package io.github.vibondarenko.aimeetingoptimizer.controllers;

import io.github.vibondarenko.aimeetingoptimizer.service.ZoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/zoom")
@RequiredArgsConstructor
public class ZoomController {
    @Autowired
    private ZoomService zoomService;

    @GetMapping("/recordings/{userId}")
    public ResponseEntity<String> getRecordings(@PathVariable String userId, @RequestHeader("Authorization") String token) {
        return ResponseEntity.ok(zoomService.getRecordings(userId, token));
    }
}
