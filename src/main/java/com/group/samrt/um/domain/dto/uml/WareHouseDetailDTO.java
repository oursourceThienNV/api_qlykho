//package com.group.samrt.um.domain.dto.uml;
//
//import com.group.samrt.um.domain.uml.WareHouse;
//import com.group.samrt.um.domain.uml.WareHouseDetail;
//import lombok.AllArgsConstructor;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//
//import javax.persistence.Column;
//import java.math.BigDecimal;
//import java.time.Instant;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class WareHouseDetailDTO {
//    private Long id;
//    private Long wareId;
//    private Long amount;
//    private BigDecimal price;
//    private String createdBy;
//    private Instant createdDt;
//    private Long updatedBy;
//    private Instant updatedDt;
//    public WareHouseDetailDTO(WareHouseDetail wareHouse) {
//        this.id = wareHouse.getId();
//        this.wareId = wareHouse.getWareId();
//        this.amount = wareHouse.getAmount();
//        this.price = wareHouse.getPrice();
//        this.createdBy = wareHouse.getCreatedBy();
//        this.updatedBy = wareHouse.getUpdatedBy();
//        this.createdDt = wareHouse.getCreatedDt();
//        this.updatedDt = wareHouse.getUpdatedDt();
//    }
//}
