package com.group.samrt.um.client.client.request;

import com.group.samrt.um.domain.dto.uml.ProductDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ListProviderInfoResponse {
    private List<ProviderDTO> listProviders;
    private ProductDTO productDTO;
    public ListProviderInfoResponse() {
    }
}
