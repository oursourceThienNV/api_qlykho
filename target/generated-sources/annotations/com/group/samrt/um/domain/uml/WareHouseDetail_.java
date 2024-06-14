package com.group.samrt.um.domain.uml;

import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WareHouseDetail.class)
public abstract class WareHouseDetail_ {

	public static volatile SingularAttribute<WareHouseDetail, Long> amount;
	public static volatile SingularAttribute<WareHouseDetail, Instant> createdDt;
	public static volatile SingularAttribute<WareHouseDetail, Long> updatedBy;
	public static volatile SingularAttribute<WareHouseDetail, Long> wareId;
	public static volatile SingularAttribute<WareHouseDetail, Long> productId;
	public static volatile SingularAttribute<WareHouseDetail, String> createdBy;
	public static volatile SingularAttribute<WareHouseDetail, Long> providerId;
	public static volatile SingularAttribute<WareHouseDetail, BigDecimal> price;
	public static volatile SingularAttribute<WareHouseDetail, Instant> updatedDt;
	public static volatile SingularAttribute<WareHouseDetail, Long> id;

	public static final String AMOUNT = "amount";
	public static final String CREATED_DT = "createdDt";
	public static final String UPDATED_BY = "updatedBy";
	public static final String WARE_ID = "wareId";
	public static final String PRODUCT_ID = "productId";
	public static final String CREATED_BY = "createdBy";
	public static final String PROVIDER_ID = "providerId";
	public static final String PRICE = "price";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";

}

