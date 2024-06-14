package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "product")
public class Product {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="product_no")
    private String pno;
    @Column(name="product_name")
    private String pname;
    @Column(name="amount")
    private Long amount;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="description")
    private String description;
    @Column(name="status")
    private Long status;
    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_by")
    private Long updatedBy;
    @Column(name="updated_dt")
    private Instant updatedDt;
}