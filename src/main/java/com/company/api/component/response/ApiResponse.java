package com.company.api.component.response;

import org.springframework.stereotype.Component;

@Component
public class ApiResponse {
    public <T> Response createCorrectResponse() {
        return Response.builder()
                .ok(true)
                .build();
    }

    public <T> Response createCorrectResponse(T data) {
        return Response.builder()
                .ok(true)
                .data(data)
                .build();
    }

    public <T> Response createErrorResponse(T errors) {
        return Response.builder()
                .ok(false)
                .errors(errors)
                .build();
    }

    public <T> Response createErrorResponse() {
        return Response.builder()
                .ok(false)
                .build();
    }
}
