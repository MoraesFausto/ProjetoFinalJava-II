package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enrollment.class)
public abstract class Enrollment_ {

	public static volatile SingularAttribute<Enrollment, Float> en_value;
	public static volatile SingularAttribute<Enrollment, LocalDate> signingDate;
	public static volatile SingularAttribute<Enrollment, LocalDate> expiringDate;

}

