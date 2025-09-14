package com.olixcorp.consultacreditoapi.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.anyString;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.olixcorp.consultacreditoapi.dto.response.CreditoSearchItemResponse;
import com.olixcorp.consultacreditoapi.model.Credito;
import com.olixcorp.consultacreditoapi.repository.CreditoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CreditoServiceTest {

  @InjectMocks
  private CreditoService creditoService;

  @Mock
  private CreditoRepository creditoRepository;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  public void procurarPorNumeroNFSE_successOneElement() {
    Credito c1 = Credito.builder()
        .id(1L)
        .numeroNfse("123")
        .build();
    List<Credito> databaseResult = List.of(c1);

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    List<CreditoSearchItemResponse> result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(1, result.size());
  }

  @Test
  public void procurarPorNumeroNFSE_successTwoElements() {
    Credito c1 = Credito.builder()
        .id(1L)
        .numeroNfse("123")
        .build();
    Credito c2 = Credito.builder()
        .id(2L)
        .numeroNfse("234")
        .build();
    List<Credito> databaseResult = List.of(c1, c2);

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    List<CreditoSearchItemResponse> result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(2, result.size());
  }

  @Test
  public void procurarPorNumeroNFSE_successNoElements() {
    List<Credito> databaseResult = new ArrayList<>();

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    List<CreditoSearchItemResponse> result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(0, result.size());
  }

  @Test
  public void procurarPorNumeroNFSE_error() {
    List<Credito> databaseResult = new ArrayList<>();

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    assertThrows(IllegalArgumentException.class, () -> {
      List<CreditoSearchItemResponse> result = this.creditoService.procurarPorNumeroNFSE(null);
    });
  }

  @Test
  public void procurarPorNumeroCredito_success() {
    Credito c1 = Credito.builder()
        .id(1L)
        .numeroCredito("123")
        .build();

    when(creditoRepository.findCreditoByNumeroCredito(anyString())).thenReturn(Optional.of(c1));

    Credito result = this.creditoService.procurarPorNumeroCredito("ABCD");
    assertNotNull(result);
    assertEquals("123", result.getNumeroCredito());
  }

  @Test
  public void procurarPorNumeroCredito_error() {
    when(creditoRepository.findCreditoByNumeroCredito(anyString())).thenReturn(Optional.empty());

    assertThrows(EntityNotFoundException.class, () -> {
      Credito result = this.creditoService.procurarPorNumeroCredito("ABCD");
    });
  }

  @Test
  public void procurarPorNumeroCredito_errorParameter() {
    List<Credito> databaseResult = new ArrayList<>();

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    assertThrows(IllegalArgumentException.class, () -> {
      this.creditoService.procurarPorNumeroCredito(null);
    });
  }
}
