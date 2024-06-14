package com.group.samrt.um.client.client.request;
import com.group.samrt.um.domain.dto.uml.ImportWareDetailDTO;
import com.group.samrt.um.domain.uml.ImportWare;
import com.group.samrt.um.domain.uml.ImportWareDetail;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
@AllArgsConstructor
public class ImportWareRequest {
    private Long id;
    private String providerNo;
    private String code;
    private String title;
    private String description;
    private String createdBy;
    private Long status;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Instant importDate;
    private List<ImportWareDetailDTO> listProducts;
}
