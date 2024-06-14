package com.group.samrt.um.domain.dto.uml;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(WareHouseDTO.class)
public abstract class WareHouseDTO_ {

	public static volatile SingularAttribute<WareHouseDTO, Instant> createdDt;
	public static volatile SingularAttribute<WareHouseDTO, String> code;
	public static volatile SingularAttribute<WareHouseDTO, Long> updatedBy;
	public static volatile SingularAttribute<WareHouseDTO, String> createdBy;
	public static volatile SingularAttribute<WareHouseDTO, String> description;
	public static volatile SingularAttribute<WareHouseDTO, Instant> updatedDt;
	public static volatile SingularAttribute<WareHouseDTO, Long> id;
	public static volatile SingularAttribute<WareHouseDTO, String> title;
	public static volatile SingularAttribute<WareHouseDTO, Long> type;
	public static volatile SingularAttribute<WareHouseDTO, Long> status;

	public static final String CREATED_DT = "createdDt";
	public static final String CODE = "code";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String DESCRIPTION = "description";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String TITLE = "title";
	public static final String TYPE = "type";
	public static final String STATUS = "status";

}

