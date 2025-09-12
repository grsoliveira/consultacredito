package com.olixcorp.consultacreditoapi.repository;

import java.util.List;
import java.util.Optional;

import com.olixcorp.consultacreditoapi.model.Credito;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditoRepository extends JpaRepository<Credito, Long> {
  Optional<List<Credito>> findCreditoByNumeroNfse(String numeroNfse);

  Optional<Credito> findCreditoByNumeroCredito(String numeroCredito);
}
