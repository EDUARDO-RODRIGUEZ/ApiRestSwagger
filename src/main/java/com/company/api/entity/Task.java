package com.company.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "task")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String description;
    @Column(name = "created_at")
    private LocalDateTime createdAt;
    private Boolean finished;

    @PrePersist
    public void prePersist() {
        setFinished(false);
        setCreatedAt(LocalDateTime.now());
    }
}
