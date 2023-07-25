package com.company.api.component.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response<T,Z> {
    private Boolean ok;
    private T data;
    private Z errors;
}
