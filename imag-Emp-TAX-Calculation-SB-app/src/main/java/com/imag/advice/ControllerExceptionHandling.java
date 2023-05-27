package com.imag.advice;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import com.imag.Exception.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ControllerExceptionHandling {
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<?> recipeNotFoundExceptionMethod(BadRequestException badReqExcp){

        Map<String, Object> errorBody = new LinkedHashMap<>();

        errorBody.put("error", "Creation Failed");
        errorBody.put("timestamp", LocalDateTime.now());
        errorBody.put("details", badReqExcp.getMessage());

        return new ResponseEntity<>(errorBody,HttpStatus.NOT_FOUND);

    }
}
