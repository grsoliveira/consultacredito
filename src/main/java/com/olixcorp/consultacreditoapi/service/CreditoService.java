package com.olixcorp.consultacreditoapi.service;

import java.util.List;
import java.util.Optional;

import com.olixcorp.consultacreditoapi.dto.response.CreditoSearchItemResponse;
import com.olixcorp.consultacreditoapi.dto.response.CreditoSearchResponse;
import com.olixcorp.consultacreditoapi.model.Credito;
import com.olixcorp.consultacreditoapi.repository.CreditoRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreditoService {
  private final CreditoRepository creditoRepository;

  public CreditoSearchResponse procurarPorNumeroNFSE(String numeroNfse) {
    this.validarParametro(numeroNfse);

    Optional<List<Credito>> dbResult = this.creditoRepository.findCreditoByNumeroNfse(numeroNfse);
    if (dbResult.isEmpty()) {
      throw new EntityNotFoundException("Nenhum crédito encontrado");
    }

    List<CreditoSearchItemResponse> items = dbResult.get().stream()
        .map(c -> {
          CreditoSearchItemResponse dto = new CreditoSearchItemResponse();
          BeanUtils.copyProperties(c, dto);
          return dto;
        })
        .toList();

    CreditoSearchResponse response = new CreditoSearchResponse();
    response.setItems(items);
    return response;
  }

  private void validarParametro(String parametro) {
    if (parametro == null || parametro.trim().length() < 1) {
      throw new IllegalArgumentException("Parâmetro inválido");
    }
  }

  public Credito procurarPorNumeroCredito(String numeroCredito) {
    this.validarParametro(numeroCredito);

    Optional<Credito> dbResult = this.creditoRepository.findCreditoByNumeroCredito(numeroCredito);
    if (dbResult.isEmpty()) {
      throw new EntityNotFoundException("Nenhum crédito encontrado");
    }
    return dbResult.get();
  }
}
