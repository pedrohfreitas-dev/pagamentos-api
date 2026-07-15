package com.portfolio.pagamentosapi.services;

import com.portfolio.pagamentosapi.exceptions.CobrancaNaoEncontradaException;
import com.portfolio.pagamentosapi.exceptions.ValorInvalidoException;
import com.portfolio.pagamentosapi.infrastructure.entity.Cobranca;
import com.portfolio.pagamentosapi.infrastructure.entity.StatusCobranca;
import com.portfolio.pagamentosapi.infrastructure.repository.CobrancaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CobrancaService {

    private final CobrancaRepository cobrancaRepository;


    public Cobranca criarCobranca(String cliente, BigDecimal valor) {

        if (valor.compareTo(BigDecimal.ZERO) <= 0) {
            throw new ValorInvalidoException("Valor Inválido");
        }

        Cobranca cobranca = new Cobranca();

        LocalDateTime dataAgora = LocalDateTime.now();

        cobranca.setCliente(cliente);
        cobranca.setValor(valor);
        cobranca.setStatus(StatusCobranca.PENDENTE);
        cobranca.setDataCriacao(dataAgora);

        return cobrancaRepository.save(cobranca);
    }

    public Cobranca buscarCobranca(Long id) {
        return cobrancaRepository.findById(id).orElseThrow(() -> new CobrancaNaoEncontradaException("Cobrança não encontrada"));
    }

    public List<Cobranca> buscarTodasCobrancas() {
        return cobrancaRepository.findAll();
    }

    public Cobranca atualizarCobranca(Long id, String cliente, BigDecimal valor) {
        Cobranca cobranca = buscarCobranca(id);
        cobranca.setCliente(cliente);
        cobranca.setValor(valor);

        return cobrancaRepository.save(cobranca);

    }

    public void deletarCobranca(Long id) {
        Cobranca cobranca = buscarCobranca((id));
        cobrancaRepository.delete(cobranca);
    }
}