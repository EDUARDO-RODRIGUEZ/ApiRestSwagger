package com.company.api.dto.task;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class TaskCreateRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
}
