package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Worker.class)
public abstract class Worker_ extends br.edu.utfpr.moraesfausto.englishschool.model.vo.Person_ {

	public static volatile SingularAttribute<Worker, Contract> contract;
	public static volatile SingularAttribute<Worker, Boolean> active;
	public static volatile SingularAttribute<Worker, String> licenseNumber;

}

