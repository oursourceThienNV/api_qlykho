package com.group.samrt.um.domain.uml;

import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImportWareDetail.class)
public abstract class ImportWareDetail_ {

	public static volatile SingularAttribute<ImportWareDetail, Long> amount;
	public static volatile SingularAttribute<ImportWareDetail, Instant> createdDt;
	public static volatile SingularAttribute<ImportWareDetail, Long> importId;
	public static volatile SingularAttribute<ImportWareDetail, Long> updatedBy;
	public static volatile SingularAttribute<ImportWareDetail, Long> createdBy;
	public static volatile SingularAttribute<ImportWareDetail, BigDecimal> price;
	public static volatile SingularAttribute<ImportWareDetail, Instant> updatedDt;
	public static volatile SingularAttribute<ImportWareDetail, Long> id;
	public static volatile SingularAttribute<ImportWareDetail, String> productNo;

	public static final String AMOUNT = "amount";
	public static final String CREATED_DT = "createdDt";
	public static final String IMPORT_ID = "importId";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String PRICE = "price";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String PRODUCT_NO = "productNo";

}

