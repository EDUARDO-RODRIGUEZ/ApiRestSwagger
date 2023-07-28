package com.company.api.dto.task;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.*;

@Data
@Builder
public class TaskUpdateRequest {
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    @AssertTrue
    private Boolean finished;
}
