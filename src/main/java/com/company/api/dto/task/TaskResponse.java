package com.company.api.dto.task;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@Builder
public class TaskResponse {
    private String title;
    private String description;
    private LocalDateTime createdAt;
    private Boolean finished;
}
