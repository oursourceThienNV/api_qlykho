package com.group.samrt.um.client.client.response;

import com.group.samrt.um.client.Common.Util.OptimizedPage;
import com.group.samrt.um.domain.dto.uml.ExportWareDTO;
import com.group.samrt.um.domain.dto.uml.ImportWareDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExportResponse {
    private OptimizedPage<ExportWareDTO> page;

    public ExportResponse() {
    }
}
