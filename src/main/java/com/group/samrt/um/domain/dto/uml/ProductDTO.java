package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.Product;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO {
    private Long id;
    private String pno;
    private String pname;
    private Long amount;
    private String description;
    private String createdBy;
    private Instant createdDt;
    private Long updatedBy;
    private Instant updatedDt;
    private Long status;
    private Instant decisionDate;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.pno = product.getPno();
        this.pname = product.getPname();
        this.description = product.getDescription();
        this.createdBy = product.getCreatedBy();
        this.createdDt = product.getCreatedDt();
        this.updatedBy = product.getUpdatedBy();
        this.updatedDt = product.getUpdatedDt();
        this.status = product.getStatus();
        this.amount=product.getAmount();
    }
}
