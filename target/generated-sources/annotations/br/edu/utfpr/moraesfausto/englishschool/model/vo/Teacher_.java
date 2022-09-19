package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Teacher.class)
public abstract class Teacher_ extends br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker_ {

	public static volatile ListAttribute<Teacher, SchoolClass> schoolClass;
	public static volatile SingularAttribute<Teacher, String> password;
	public static volatile SingularAttribute<Teacher, Team> team;
	public static volatile SingularAttribute<Teacher, Meeting> meeting;

}

