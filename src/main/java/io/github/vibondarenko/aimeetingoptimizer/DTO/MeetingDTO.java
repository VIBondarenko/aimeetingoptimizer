package io.github.vibondarenko.aimeetingoptimizer.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class MeetingDTO {
    private Long id;
    private String title;
    private String transcript;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}

