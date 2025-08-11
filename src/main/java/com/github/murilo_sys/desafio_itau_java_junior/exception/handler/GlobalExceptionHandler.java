package com.github.murilo_sys.desafio_itau_java_junior.exception.handler;

import com.github.murilo_sys.desafio_itau_java_junior.exception.BadRequestException;
import com.github.murilo_sys.desafio_itau_java_junior.exception.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionResponse> handleBadRequestException(BadRequestException ex, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                "400",
                ex.getMessage(),
                request.getRequestURI()
        );


        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }



}
