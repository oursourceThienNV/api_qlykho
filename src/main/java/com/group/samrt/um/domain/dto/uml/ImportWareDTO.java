package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.ImportWare;
import com.group.samrt.um.domain.uml.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportWareDTO {
    private Long id;
    private String providerNo;
    private String code;
    private String title;
    private String description;
    private Instant importDate;
    private Long createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Long status;
    public ImportWareDTO(ImportWare wareHouse) {
        this.id = wareHouse.getId();
        this.code=wareHouse.getCode();
        this.providerNo = wareHouse.getProviderNo();
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
