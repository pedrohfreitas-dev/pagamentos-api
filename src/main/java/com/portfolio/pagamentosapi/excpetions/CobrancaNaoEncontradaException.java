package com.portfolio.pagamentosapi.excpetions;


public class CobrancaNaoEncontradaException extends RuntimeException {
    public CobrancaNaoEncontradaException(String mensagem) {
        super(mensagem);
    }

}
