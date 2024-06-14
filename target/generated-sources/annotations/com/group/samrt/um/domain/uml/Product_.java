package com.group.samrt.um.domain.uml;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Product.class)
public abstract class Product_ {

	public static volatile SingularAttribute<Product, String> pno;
	public static volatile SingularAttribute<Product, Long> amount;
	public static volatile SingularAttribute<Product, Instant> createdDt;
	public static volatile SingularAttribute<Product, Long> updatedBy;
	public static volatile SingularAttribute<Product, String> createdBy;
	public static volatile SingularAttribute<Product, String> pname;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Instant> updatedDt;
	public static volatile SingularAttribute<Product, Long> id;
	public static volatile SingularAttribute<Product, Long> status;

	public static final String PNO = "pno";
	public static final String AMOUNT = "amount";
	public static final String CREATED_DT = "createdDt";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String PNAME = "pname";
	public static final String DESCRIPTION = "description";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String STATUS = "status";

}

