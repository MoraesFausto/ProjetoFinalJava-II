package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Contract.class)
public abstract class Contract_ {

	public static volatile SingularAttribute<Contract, LocalDate> signingDate;
	public static volatile SingularAttribute<Contract, LocalDate> expiringDate;
	public static volatile SingularAttribute<Contract, String> description;
	public static volatile SingularAttribute<Contract, BigDecimal> value;

}

