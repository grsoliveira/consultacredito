package com.olixcorp.consultacreditoapi.service;

import com.olixcorp.consultacreditoapi.dto.response.CreditoSearchResponse;
import com.olixcorp.consultacreditoapi.model.Credito;
import com.olixcorp.consultacreditoapi.repository.CreditoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    CreditoSearchResponse result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(1, result.getItems().size());
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

    CreditoSearchResponse result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(2, result.getItems().size());
  }

  @Test
  public void procurarPorNumeroNFSE_successNoElements() {
    List<Credito> databaseResult = new ArrayList<>();

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    CreditoSearchResponse result = this.creditoService.procurarPorNumeroNFSE("ABCD");
    assertNotNull(result);
    assertEquals(0, result.getItems().size());
  }

  @Test
  public void procurarPorNumeroNFSE_error() {
    List<Credito> databaseResult = new ArrayList<>();

    when(creditoRepository.findCreditoByNumeroNfse(anyString())).thenReturn(Optional.of(databaseResult));

    assertThrows(IllegalArgumentException.class, () -> {
      CreditoSearchResponse result = this.creditoService.procurarPorNumeroNFSE(null);
    });

  }
}
