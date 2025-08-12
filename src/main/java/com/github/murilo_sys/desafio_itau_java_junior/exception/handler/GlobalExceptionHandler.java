package com.github.murilo_sys.desafio_itau_java_junior.exception.handler;

import com.fasterxml.jackson.databind.exc.ValueInstantiationException;
import com.github.murilo_sys.desafio_itau_java_junior.exception.UnprocessableEntityException;
import com.github.murilo_sys.desafio_itau_java_junior.exception.response.ExceptionResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class GlobalExceptionHandler {

    //Entidade Lida porém não tem lógica 422
    @ExceptionHandler(UnprocessableEntityException.class)
    public ResponseEntity<ExceptionResponse> handleUnprocessableEntityException(UnprocessableEntityException ex, HttpServletRequest request) {
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                "422",
                ex.getMessage(),
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(response);
    }

    // Bad Request 400
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex, HttpServletRequest request) {

        String mensagem = "Erro no corpo da requisição";

        if (ex.getCause() instanceof ValueInstantiationException cause) {
            mensagem = cause.getOriginalMessage();

            if (mensagem != null && mensagem.contains("problem:")) {
                mensagem = mensagem.substring(mensagem.indexOf("problem:") + 8).trim();
            }
        }

        
        ExceptionResponse response = new ExceptionResponse(
                new Date(),
                "400",
                mensagem,
                request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
