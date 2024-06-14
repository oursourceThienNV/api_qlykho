package com.group.samrt.um.client.client.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponeByWare {
    private Long id;
    private String productNo;
    private Long amount;
    private String productName;
    private BigDecimal price;
    private String providerNo;
    private String providerName;
}
