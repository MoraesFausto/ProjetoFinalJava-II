package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Coordinator.class)
public abstract class Coordinator_ extends br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker_ {

	public static volatile SingularAttribute<Coordinator, String> password;
	public static volatile ListAttribute<Coordinator, Meeting> meetings;
	public static volatile ListAttribute<Coordinator, Event> events;

}

