package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.ImportWareDetail;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ImportWareDetailDTO {
    private Long id;
    private Long importId;
    private String productNo;
    private Long amount;
    private BigDecimal price;
    private Long createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    public ImportWareDetailDTO(ImportWareDetail item){
        this.id=item.getId();
        this.productNo=item.getProductNo();
        this.setImportId(item.getImportId());
        this.setAmount(item.getAmount());
        this.setPrice(item.getPrice());
        this.createdBy = item.getCreatedBy();
        this.createdDt = item.getCreatedDt();
        this.updatedBy = item.getUpdatedBy();
        this.updatedDt = item.getUpdatedDt();
    }
}
