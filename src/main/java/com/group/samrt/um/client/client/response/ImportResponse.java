package com.group.samrt.um.client.client.response;

import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.domain.dto.uml.ImportWareDTO;
import com.group.samrt.um.domain.dto.uml.ProviderDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ImportResponse {
    private OptimizedPage<ImportWareDTO> page;

    public ImportResponse() {
    }
}
