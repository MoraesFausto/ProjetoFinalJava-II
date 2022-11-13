package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Enrollment.class)
public abstract class Enrollment_ extends br.edu.utfpr.moraesfausto.englishschool.model.vo.Contract_ {

	public static volatile SingularAttribute<Enrollment, LocalDate> extensionExpiringDate;
	public static volatile SingularAttribute<Enrollment, BigDecimal> extensionValue;

}

