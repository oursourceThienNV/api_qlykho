package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.Product;
import com.group.samrt.um.domain.uml.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProviderDTO {
    private Long id;
    private String providerNo;
    private String providerName;
    private String email;
    private String phoneNumber;
    private String address;
    private String createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Long status;
    private Instant decisionDate;

    public ProviderDTO(Provider provider) {
        this.id = provider.getId();
        this.providerNo = provider.getProviderNo();
        this.providerName = provider.getProviderName();
        this.email = provider.getEmail();
        this.createdBy = provider.getCreatedBy();
        this.createdDt = provider.getCreatedDt();
        this.updatedBy = provider.getUpdatedBy();
        this.updatedDt = provider.getUpdatedDt();
        this.status = provider.getStatus();
        this.phoneNumber = provider.getPhoneNumber();
        this.address=provider.getAddress();
    }
}
