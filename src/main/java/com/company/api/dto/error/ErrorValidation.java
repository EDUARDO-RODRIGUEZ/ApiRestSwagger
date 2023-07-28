package com.company.api.dto.error;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorValidation {
    private String field;
    private String error;
}
