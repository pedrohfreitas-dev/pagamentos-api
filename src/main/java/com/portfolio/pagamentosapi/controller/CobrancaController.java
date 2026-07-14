package com.portfolio.pagamentosapi.controller;

import com.portfolio.pagamentosapi.infrastructure.entity.Cobranca;
import com.portfolio.pagamentosapi.services.CobrancaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.math.BigDecimal;

@RestController
@RequestMapping("/cobrancas")
@RequiredArgsConstructor
public class CobrancaController {
    private final CobrancaService cobrancaService;



    @PostMapping
    public ResponseEntity<Cobranca> criarCobranca(@RequestBody Cobranca cobranca) {
        return ResponseEntity.status(HttpStatus.CREATED).body(cobrancaService.criarCobranca(cobranca.getCliente(),cobranca.getValor()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cobranca> buscarCobranca(@PathVariable Long id) {
       return ResponseEntity.ok(cobrancaService.buscarCobranca(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cobranca> atualizarCobranca(@PathVariable Long id,@RequestBody Cobranca cobranca) {
        return ResponseEntity.ok(cobrancaService.atualizarCobranca(id,cobranca.getCliente(),cobranca.getValor()));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletarCobranca(@PathVariable Long id) {
        cobrancaService.deletarCobranca(id);
        return ResponseEntity.ok("Usuario deletado com sucesso");
    }


}
