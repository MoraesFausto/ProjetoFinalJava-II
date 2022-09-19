package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Team.class)
public abstract class Team_ {

	public static volatile SingularAttribute<Team, Coordinator> coordinator;
	public static volatile ListAttribute<Team, Teacher> teachers;
	public static volatile SingularAttribute<Team, Long> id;
	public static volatile SingularAttribute<Team, Meeting> meeting;

}

