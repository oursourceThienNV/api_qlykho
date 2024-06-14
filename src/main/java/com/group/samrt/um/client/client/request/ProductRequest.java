package com.group.samrt.um.client.client.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@AllArgsConstructor
public class ProductRequest {
    private Long id;
    private String pno;
    private String pname;
    private String description;
    private Long amount;
    private Long status;
    private Long createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
}
