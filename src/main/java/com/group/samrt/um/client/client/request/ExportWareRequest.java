package com.group.samrt.um.client.client.request;
import com.group.samrt.um.domain.dto.uml.ExportWareDetailDTO;
import com.group.samrt.um.domain.dto.uml.ImportWareDetailDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class ExportWareRequest {
    private Long id;
    private String code;
    private String title;
    private String description;
    private String createdBy;
    private Long status;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Instant importDate;
    private List<ExportWareDetailDTO> listProducts;
}
