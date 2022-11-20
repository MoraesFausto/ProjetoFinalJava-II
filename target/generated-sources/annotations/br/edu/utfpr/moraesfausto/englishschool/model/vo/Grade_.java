package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Grade.class)
public abstract class Grade_ {

	public static volatile SingularAttribute<Grade, Boolean> approved;
	public static volatile SingularAttribute<Grade, Test> test;
	public static volatile SingularAttribute<Grade, Student> student;
	public static volatile SingularAttribute<Grade, String> observation;
	public static volatile SingularAttribute<Grade, Long> id;
	public static volatile SingularAttribute<Grade, Float> points;

}

