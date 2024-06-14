package com.group.samrt.um.client.client.response;

import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.domain.dto.uml.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private OptimizedPage<ProductDTO> page;

    public ProductResponse() {
    }
}
