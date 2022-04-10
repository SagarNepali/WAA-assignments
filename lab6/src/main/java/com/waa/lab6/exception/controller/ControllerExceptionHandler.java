package com.waa.lab6.exception.controller;

import com.waa.lab6.exception.domain.DataNotFoundException;
import com.waa.lab6.utils.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@ResponseBody
public class ControllerExceptionHandler {
    @ExceptionHandler(value = {DataNotFoundException.class})
    public ResponseEntity<?> DataNotFoundException(DataNotFoundException ex) {
        ApiError errorMessage = new ApiError()
                .builder()
                .message(ex.getMessage())
                .statusCode("404")
                .description("NOT_FOUND")
                .build();
        return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
    }
}
