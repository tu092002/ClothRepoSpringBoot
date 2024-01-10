package com.sergio.jwt.backend.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String entityName, String fieldName, Object fieldValue) {
        super(entityName + " not found with " + fieldName + " : '" + fieldValue + "'");
    }
}
