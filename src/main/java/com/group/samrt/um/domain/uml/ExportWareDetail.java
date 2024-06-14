package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name ="export_ware_dt")
public class ExportWareDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="import_id")
    private Long importId;
    @Column(name="product_no")
    private String productNo;
    @Column(name="provider_no")
    private String providerNo;
    @Column(name="amount")
    private Long amount;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="created_by")
    private Long createdBy;
    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_by")
    private Long updatedBy;
    @Column(name="updated_dt")
    private Instant updatedDt;
}
