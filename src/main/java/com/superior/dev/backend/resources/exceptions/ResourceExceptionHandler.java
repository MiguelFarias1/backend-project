package com.superior.dev.backend.resources.exceptions;

import com.superior.dev.backend.services.exceptions.CategoryNotFoundException;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<StandardError> categoryNotFound(CategoryNotFoundException e, HttpServletRequest request){

        StandardError error = new StandardError();

        error.setTimeStamp(Instant.now());
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setPath(request.getRequestURI());
        error.setError("Resource Not Found");
        error.setMessage(e.getMessage());

        return ResponseEntity.status(error.getStatus()).body(error);
    }
}
