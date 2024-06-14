package com.group.samrt.um.client.client.response;

import com.group.samrt.um.domain.dto.uml.ImportWareDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import com.group.samrt.um.domain.dto.uml.UserDetailDTO;
import com.group.samrt.um.domain.uml.Product;
import com.group.samrt.um.domain.uml.Provider;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ImportInfoResponse {
    private ImportWareDTO importWare;
    private List<ProductResponeByWare> listProducts;
    private ProviderDTO provider;

    public ImportInfoResponse() {
    }
}
