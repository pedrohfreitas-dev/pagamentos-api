package com.portfolio.pagamentosapi.infrastructure.repository;

import com.portfolio.pagamentosapi.infrastructure.entity.Cobranca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CobrancaRepository extends JpaRepository<Cobranca, Long> {
}
