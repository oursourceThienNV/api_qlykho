package com.group.samrt.um.domain.uml;

import java.math.BigDecimal;
import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ExportWareDetail.class)
public abstract class ExportWareDetail_ {

	public static volatile SingularAttribute<ExportWareDetail, Long> amount;
	public static volatile SingularAttribute<ExportWareDetail, Instant> createdDt;
	public static volatile SingularAttribute<ExportWareDetail, Long> importId;
	public static volatile SingularAttribute<ExportWareDetail, Long> updatedBy;
	public static volatile SingularAttribute<ExportWareDetail, Long> createdBy;
	public static volatile SingularAttribute<ExportWareDetail, BigDecimal> price;
	public static volatile SingularAttribute<ExportWareDetail, String> providerNo;
	public static volatile SingularAttribute<ExportWareDetail, Instant> updatedDt;
	public static volatile SingularAttribute<ExportWareDetail, Long> id;
	public static volatile SingularAttribute<ExportWareDetail, String> productNo;

	public static final String AMOUNT = "amount";
	public static final String CREATED_DT = "createdDt";
	public static final String IMPORT_ID = "importId";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String PRICE = "price";
	public static final String PROVIDER_NO = "providerNo";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String PRODUCT_NO = "productNo";

}

