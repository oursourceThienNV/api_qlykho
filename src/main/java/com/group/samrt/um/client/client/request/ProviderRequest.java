package com.group.samrt.um.client.client.request;

import lombok.Data;

import java.time.Instant;
@Data
public class ProviderRequest {
    private Long id;
    private String providerNo;
    private String providerName;
    private String email;
    private String address;
    private String phoneNumber;
    private Long status;
    private Long createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
}
