package com.group.samrt.um.domain.uml;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ImportWare.class)
public abstract class ImportWare_ {

	public static volatile SingularAttribute<ImportWare, Instant> createdDt;
	public static volatile SingularAttribute<ImportWare, String> code;
	public static volatile SingularAttribute<ImportWare, Long> updatedBy;
	public static volatile SingularAttribute<ImportWare, Long> createdBy;
	public static volatile SingularAttribute<ImportWare, Instant> importDate;
	public static volatile SingularAttribute<ImportWare, String> providerNo;
	public static volatile SingularAttribute<ImportWare, String> description;
	public static volatile SingularAttribute<ImportWare, Instant> updatedDt;
	public static volatile SingularAttribute<ImportWare, Long> id;
	public static volatile SingularAttribute<ImportWare, String> title;
	public static volatile SingularAttribute<ImportWare, Long> status;

	public static final String CREATED_DT = "createdDt";
	public static final String CODE = "code";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String IMPORT_DATE = "importDate";
	public static final String PROVIDER_NO = "providerNo";
	public static final String DESCRIPTION = "description";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String STATUS = "status";

}

