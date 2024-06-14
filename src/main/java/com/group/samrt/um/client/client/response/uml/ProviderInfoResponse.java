package com.group.samrt.um.client.client.response.uml;

import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import com.group.samrt.um.domain.dto.uml.UserDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProviderInfoResponse {
    private ProviderDTO providerDTO;

    public ProviderInfoResponse() {
    }
}
