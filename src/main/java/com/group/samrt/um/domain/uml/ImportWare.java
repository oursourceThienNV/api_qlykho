package com.group.samrt.um.domain.uml;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;

@Data
@Entity
@Table(name = "import_ware")
public class ImportWare {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="code")
    private String code;
    @Column(name="provider_no")
    private String providerNo;
    @Column(name="title")
    private String title;
    @Column(name="description")
    private String description;
    @Column(name="importDate")
    private Instant importDate;
    @Column(name="created_by")
    private Long createdBy;
    @Column(name="created_dt")
    private Instant createdDt;
    @Column(name="updated_by")
    private Long updatedBy;
    @Column(name="updated_dt")
    private Instant updatedDt;
    @Column(name="status")
    private Long status;
}
