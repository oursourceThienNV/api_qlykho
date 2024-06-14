package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.ExportWare;
import com.group.samrt.um.domain.uml.ImportWare;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExportWareDTO {
    private Long id;
    private String code;
    private String title;
    private String description;
    private Instant importDate;
    private Long createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Long status;
    public ExportWareDTO(ExportWare wareHouse) {
        this.id = wareHouse.getId();
        this.code=wareHouse.getCode();
        this.title = wareHouse.getTitle();
        this.description = wareHouse.getDescription();
        this.importDate = wareHouse.getImportDate();
        this.createdBy = wareHouse.getCreatedBy();
        this.createdDt = wareHouse.getCreatedDt();
        this.updatedBy = wareHouse.getUpdatedBy();
        this.updatedDt = wareHouse.getUpdatedDt();
        this.status = wareHouse.getStatus();
    }
}
