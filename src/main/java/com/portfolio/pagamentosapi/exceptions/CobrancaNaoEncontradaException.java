package com.portfolio.pagamentosapi.exceptions;


public class CobrancaNaoEncontradaException extends RuntimeException {

    public CobrancaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }
}