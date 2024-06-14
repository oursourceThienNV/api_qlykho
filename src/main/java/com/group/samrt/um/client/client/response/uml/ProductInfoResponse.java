package com.group.samrt.um.client.client.response.uml;

import com.group.samrt.um.domain.dto.uml.ProductDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductInfoResponse {
    private ProductDTO productDTO;

    public ProductInfoResponse() {
    }
}
