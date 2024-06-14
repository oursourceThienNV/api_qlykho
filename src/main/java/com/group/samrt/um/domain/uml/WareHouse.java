package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "warehouse")
public class WareHouse {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="productNo")
    private String productNo;
    @Column(name="providerNo")
    private String providerNo;
    @Column(name="amount")
    private Long amount;
}
