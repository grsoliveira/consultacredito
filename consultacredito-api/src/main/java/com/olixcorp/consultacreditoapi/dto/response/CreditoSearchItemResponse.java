package com.olixcorp.consultacreditoapi.dto.response;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

/**
 * DTO for {@link com.olixcorp.consultacreditoapi.model.Credito}
 */
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CreditoSearchItemResponse implements Serializable {
  String numeroCredito;
  String numeroNfse;
  LocalDate dataConstituicao;
  BigDecimal valorIssqn;
  String tipoCredito;
  boolean simplesNacional;
  BigDecimal aliquota;
  BigDecimal valorFaturado;
  BigDecimal valorDeducao;
  BigDecimal baseCalculo;
}