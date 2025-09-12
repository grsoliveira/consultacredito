package com.olixcorp.consultacreditoapi.controller;


import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import jakarta.transaction.Transactional;
import lombok.SneakyThrows;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;

@Transactional
@ActiveProfiles("test")
@SpringBootTest(webEnvironment = RANDOM_PORT)
@AutoConfigureMockMvc
public class CreditoControllerTest {

  @Autowired
  protected MockMvc mvc;

  @Test
  @SneakyThrows
  void testProcurarPorNumeroNFSE() {
    RequestBuilder request = get(
        "/api/v1/creditos/1232")
        .contentType(APPLICATION_JSON);
    mvc.perform(request)
        .andDo(print())
        .andExpect(status().isOk());
  }

  @Test
  @SneakyThrows
  void testProcurarPorNumeroCredito() {
    RequestBuilder request = get(
        "/api/v1/creditos/credito/123456")
        .contentType(APPLICATION_JSON);
    mvc.perform(request)
        .andDo(print())
        .andExpect(status().isOk());
  }
}
