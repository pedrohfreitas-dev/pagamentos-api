package com.portfolio.pagamentosapi.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(CobrancaNaoEncontradaException.class)
    public ResponseEntity<String> tratarCobrancaNaoEncontradaException(CobrancaNaoEncontradaException exception) {
         return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(ValorInvalidoException.class)
    public ResponseEntity<String> tratarValorInvalidoException(ValorInvalidoException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
    }

}
