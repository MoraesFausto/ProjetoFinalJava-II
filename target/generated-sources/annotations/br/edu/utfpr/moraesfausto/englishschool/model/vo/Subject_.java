package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Subject.class)
public abstract class Subject_ {

	public static volatile ListAttribute<Subject, Book> books;
	public static volatile SingularAttribute<Subject, String> description;
	public static volatile SingularAttribute<Subject, Long> id;
	public static volatile SingularAttribute<Subject, String> title;

}

