package com.rehnemacollege.backend.configuration;

import com.rehnemacollege.backend.model.exception.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @Data
    @AllArgsConstructor
    static class ExceptionResponse {
        private String message;
        private Integer id;
    }

    @ExceptionHandler(value={EntityNotFoundException.class})
    protected ResponseEntity<Object> handleEntityNotFound(EntityNotFoundException ex, WebRequest req) {
        return this.handleExceptionInternal(ex,
                new ExceptionResponse(ex.getMessage(), ex.getId()),
                new HttpHeaders(), HttpStatus.NOT_FOUND, req);
    }

}
