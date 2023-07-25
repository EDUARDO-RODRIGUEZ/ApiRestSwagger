package com.company.api.dto.task;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TaskUpdateRequest {
    private String title;
    private String description;
    private Boolean finished;
}
