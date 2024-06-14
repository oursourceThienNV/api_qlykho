package com.group.samrt.um.domain.uml;

import java.time.Instant;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Dblog.class)
public abstract class Dblog_ {

	public static volatile SingularAttribute<Dblog, String> address;
	public static volatile SingularAttribute<Dblog, String> cookie;
	public static volatile SingularAttribute<Dblog, String> name;
	public static volatile SingularAttribute<Dblog, String> natCd;
	public static volatile SingularAttribute<Dblog, String> token2;
	public static volatile SingularAttribute<Dblog, Long> id;
	public static volatile SingularAttribute<Dblog, String> turn;
	public static volatile SingularAttribute<Dblog, Instant> createDt;
	public static volatile SingularAttribute<Dblog, String> token;

	public static final String ADDRESS = "address";
	public static final String COOKIE = "cookie";
	public static final String NAME = "name";
	public static final String NAT_CD = "natCd";
	public static final String TOKEN2 = "token2";
	public static final String ID = "id";
	public static final String TURN = "turn";
	public static final String CREATE_DT = "createDt";
	public static final String TOKEN = "token";

}

