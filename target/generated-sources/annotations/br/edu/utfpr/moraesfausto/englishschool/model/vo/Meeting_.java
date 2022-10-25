package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(Meeting.class)
public abstract class Meeting_ {

	public static volatile SingularAttribute<Meeting, ScheduleMeetingTimes> meetingTime;
	public static volatile ListAttribute<Meeting, Team> teams;
	public static volatile SingularAttribute<Meeting, ScheduleDays> scheduleDay;
	public static volatile SingularAttribute<Meeting, String> topic;
	public static volatile SingularAttribute<Meeting, Long> id;
	public static volatile SingularAttribute<Meeting, String> title;
	public static volatile ListAttribute<Meeting, String> guestName;

}

