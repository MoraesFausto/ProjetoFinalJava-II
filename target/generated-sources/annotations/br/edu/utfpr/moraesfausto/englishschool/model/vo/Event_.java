package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Event.class)
public abstract class Event_ {

	public static volatile SingularAttribute<Event, Coordinator> coordinator;
	public static volatile SingularAttribute<Event, LocalDate> firstDay;
	public static volatile SingularAttribute<Event, Level> level;
	public static volatile SingularAttribute<Event, LocalDate> lastDay;
	public static volatile SingularAttribute<Event, Long> id;
	public static volatile SingularAttribute<Event, String> title;
	public static volatile SingularAttribute<Event, Float> profit;
	public static volatile SingularAttribute<Event, Float> budget;

}

