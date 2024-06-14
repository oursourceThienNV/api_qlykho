package com.group.samrt.um.client.client.response;

import com.group.samrt.um.domain.dto.uml.ExportWareDTO;
import com.group.samrt.um.domain.dto.uml.ImportWareDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ExportInfoResponse {
    private ExportWareDTO exportWareDTO;
    private List<ProductResponeByWare> listProducts;
    public ExportInfoResponse() {
    }
}
