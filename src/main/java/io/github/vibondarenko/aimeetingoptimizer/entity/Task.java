package io.github.vibondarenko.aimeetingoptimizer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
public class Task {
    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    private String assignedTo;
    private LocalDateTime startDateTime;
    private LocalDateTime deadlineDateTime;

    @ManyToOne
    private Meeting meeting;

}
    

