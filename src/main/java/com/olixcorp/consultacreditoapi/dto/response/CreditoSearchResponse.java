package com.olixcorp.consultacreditoapi.dto.response;

import java.util.List;

import lombok.Data;

@Data
public class CreditoSearchResponse {
  private List<CreditoSearchItemResponse> items;
}
