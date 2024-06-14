package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "provider")
public class Provider {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="provider_no")
    private String providerNo;
    @Column(name="provider_name")
    private String providerName;
    @Column(name="email")
    private String email;
    @Column(name="phone")
    private String phoneNumber;
    @Column(name="address")
    private String address;
    @Column(name="created_by")
    private String createdBy;
    @Column(name="status")
    private Long status;
    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_by")
    private Long updatedBy;
    @Column(name="updated_dt")
    private Instant updatedDt;
}