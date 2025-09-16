package io.github.vibondarenko.aimeetingoptimizer.audio;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

@RestController
@RequestMapping("/api/audio")
public class AudioRecorderController {

    @Autowired
    private AudioRecorderService audioRecorderService;

    @PostMapping("/start")
    public ResponseEntity<String> startRecording(@RequestParam String filePath) {
        try {
            audioRecorderService.startRecording(filePath);
            return ResponseEntity.ok("Recording started");
        } catch (LineUnavailableException | IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error: " + e.getMessage());
        }
    }

    @PostMapping("/stop")
    public ResponseEntity<String> stopRecording() {
        audioRecorderService.stopRecording();
        return ResponseEntity.ok("Recording stopped");
    }

    @GetMapping("/status")
    public ResponseEntity<String> getStatus() {
        return ResponseEntity.ok(audioRecorderService.isRecording() ? "Recording" : "Stopped");
    }
}
