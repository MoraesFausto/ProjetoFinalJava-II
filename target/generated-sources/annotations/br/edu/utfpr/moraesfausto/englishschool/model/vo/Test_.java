package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Test.class)
public abstract class Test_ {

	public static volatile SingularAttribute<Test, Float> minGrade;
	public static volatile SingularAttribute<Test, Book> book;
	public static volatile SingularAttribute<Test, TestType> testType;
	public static volatile SingularAttribute<Test, Long> id;
	public static volatile ListAttribute<Test, Grade> grades;

}

