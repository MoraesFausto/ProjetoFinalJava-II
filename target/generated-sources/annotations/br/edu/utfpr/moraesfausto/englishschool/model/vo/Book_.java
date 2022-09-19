package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Book.class)
public abstract class Book_ {

	public static volatile ListAttribute<Book, SchoolClass> schoolClass;
	public static volatile ListAttribute<Book, Test> test;
	public static volatile SingularAttribute<Book, Level> level;
	public static volatile SingularAttribute<Book, Subject> subject;
	public static volatile SingularAttribute<Book, Long> id;
	public static volatile SingularAttribute<Book, Float> value;

}

