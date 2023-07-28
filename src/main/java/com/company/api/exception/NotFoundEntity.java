package com.company.api.exception;

public class NotFoundEntity extends RuntimeException {
    public NotFoundEntity() {
        super();
    }

    public NotFoundEntity(String message) {
        super(message);
    }
}
