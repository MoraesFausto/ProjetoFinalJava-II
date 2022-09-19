package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Level.class)
public abstract class Level_ {

	public static volatile ListAttribute<Level, Book> book;
	public static volatile SingularAttribute<Level, String> description;
	public static volatile SingularAttribute<Level, Long> id;
	public static volatile SingularAttribute<Level, String> title;

}

