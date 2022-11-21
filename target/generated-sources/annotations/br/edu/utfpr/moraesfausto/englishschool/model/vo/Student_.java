package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Student.class)
public abstract class Student_ extends br.edu.utfpr.moraesfausto.englishschool.model.vo.Person_ {

	public static volatile SingularAttribute<Student, SchoolClass> schoolClass;
	public static volatile SingularAttribute<Student, Float> schoolarship;
	public static volatile SingularAttribute<Student, Contract> contract;
	public static volatile ListAttribute<Student, Grade> grades;

}

