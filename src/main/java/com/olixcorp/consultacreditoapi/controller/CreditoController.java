package com.olixcorp.consultacreditoapi.controller;

import com.olixcorp.consultacreditoapi.dto.response.CreditoSearchResponse;
import com.olixcorp.consultacreditoapi.model.Credito;
import com.olixcorp.consultacreditoapi.service.CreditoService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1/creditos")
@CrossOrigin("*")
@RestController
@AllArgsConstructor
public class CreditoController {
  private CreditoService creditoService;

  @GetMapping(value = "{numeroNfse}")
  public ResponseEntity<CreditoSearchResponse> procurarPorNumeroNFSE(@PathVariable String numeroNfse) {
    CreditoSearchResponse response = this.creditoService.procurarPorNumeroNFSE(numeroNfse);
    return ResponseEntity.ok(response);
  }

  @GetMapping(value = "/credito/{numeroCredito}")
  public ResponseEntity<Credito> procurarPorNumeroCredito(@PathVariable String numeroCredito) {
    Credito credito = this.creditoService.procurarPorNumeroCredito(numeroCredito);
    return ResponseEntity.ok(credito);
  }

}
