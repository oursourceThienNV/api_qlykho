package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@Entity
@Table(name = "ware_house_detail")
public class WareHouseDetail {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="ware_id")
    private Long wareId;
    @Column(name="product_id")
    private Long productId;
    @Column(name="provider_id")
    private Long providerId;
    @Column(name="amount")
    private Long amount;
    @Column(name="price")
    private BigDecimal price;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_by")
    private Long updatedBy;
    @Column(name="updated_dt")
    private Instant updatedDt;
}
