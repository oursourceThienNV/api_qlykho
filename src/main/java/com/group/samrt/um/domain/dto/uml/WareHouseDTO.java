package com.group.samrt.um.domain.dto.uml;

import com.group.samrt.um.domain.uml.AdminUser;
import com.group.samrt.um.domain.uml.WareHouse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class WareHouseDTO {
    private Long id;
    private String productNo;
    private String providerNo;
    private Long amount;
    public WareHouseDTO(WareHouse wareHouse) {
        this.id = wareHouse.getId();
        this.productNo = wareHouse.getProductNo();
        this.providerNo = wareHouse.getProviderNo();
        this.amount = wareHouse.getAmount();
    }
}
