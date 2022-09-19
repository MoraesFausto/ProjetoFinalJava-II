package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(SchoolClass.class)
public abstract class SchoolClass_ {

	public static volatile SingularAttribute<SchoolClass, Schedule> schedule;
	public static volatile SingularAttribute<SchoolClass, Teacher> teacher;
	public static volatile ListAttribute<SchoolClass, Student> student;
	public static volatile SingularAttribute<SchoolClass, Book> book;
	public static volatile SingularAttribute<SchoolClass, Long> id;

}

