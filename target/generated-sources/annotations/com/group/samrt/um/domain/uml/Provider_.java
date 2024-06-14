package com.group.samrt.um.domain.uml;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Provider.class)
public abstract class Provider_ {

	public static volatile SingularAttribute<Provider, Instant> createdDt;
	public static volatile SingularAttribute<Provider, String> phoneNumber;
	public static volatile SingularAttribute<Provider, String> address;
	public static volatile SingularAttribute<Provider, Long> updatedBy;
	public static volatile SingularAttribute<Provider, String> createdBy;
	public static volatile SingularAttribute<Provider, String> providerNo;
	public static volatile SingularAttribute<Provider, Instant> updatedDt;
	public static volatile SingularAttribute<Provider, Long> id;
	public static volatile SingularAttribute<Provider, String> providerName;
	public static volatile SingularAttribute<Provider, String> email;
	public static volatile SingularAttribute<Provider, Long> status;

	public static final String CREATED_DT = "createdDt";
	public static final String PHONE_NUMBER = "phoneNumber";
	public static final String ADDRESS = "address";
	public static final String UPDATED_BY = "updatedBy";
	public static final String CREATED_BY = "createdBy";
	public static final String PROVIDER_NO = "providerNo";
	public static final String UPDATED_DT = "updatedDt";
	public static final String ID = "id";
	public static final String PROVIDER_NAME = "providerName";
	public static final String EMAIL = "email";
	public static final String STATUS = "status";

}

