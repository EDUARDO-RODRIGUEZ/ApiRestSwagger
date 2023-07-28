package com.company.api.handler;

import com.company.api.component.response.ApiResponse;
import com.company.api.component.response.Response;
import com.company.api.dto.error.ErrorValidation;
import com.company.api.exception.NotFoundEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @Autowired
    private ApiResponse response;

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Response> handlerValidationError(MethodArgumentNotValidException ex) {
        List<ErrorValidation> errors = ex.getBindingResult().getFieldErrors().stream().map((error) -> (
                ErrorValidation.builder()
                        .field(error.getField())
                        .error(error.getDefaultMessage())
                        .build()
        )).collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response.createErrorResponse(errors));
    }

    @ExceptionHandler(value = {NotFoundEntity.class})
    public ResponseEntity<Response> handlerNotFoundEntity(NotFoundEntity ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                response.createErrorResponse(ex.getMessage())
        );
    }


}
