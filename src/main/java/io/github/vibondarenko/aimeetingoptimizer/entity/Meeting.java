package io.github.vibondarenko.aimeetingoptimizer.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

@Entity
@Table(name = "meeting")
@Data
public class Meeting {
    @Getter
    @Setter
    @jakarta.persistence.Id
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String transcript;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}