package io.github.vibondarenko.aimeetingoptimizer.DTO;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskDTO {
    private Long id;
    private Long meetingId;
    private String title;
    private String description;
    private String assignedTo;
    private LocalDateTime startDateTime;
    private LocalDateTime deadlineDateTime;
}
