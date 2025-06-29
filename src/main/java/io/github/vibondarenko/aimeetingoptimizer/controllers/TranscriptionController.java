package io.github.vibondarenko.aimeetingoptimizer.controllers;

import io.github.vibondarenko.aimeetingoptimizer.service.TranscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/transcription")
public class TranscriptionController {

    @Autowired
    private TranscriptionService transcriptionService;

    @PostMapping("/audio")
    public ResponseEntity<String> transcribeAudio(@RequestParam("file") MultipartFile audioFile) {
        try {
            String transcript = transcriptionService.transcribeAudio(audioFile.getBytes());
            return ResponseEntity.ok(transcript);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Помилка транскрипції аудіо: " + e.getMessage());
        }
    }
}
