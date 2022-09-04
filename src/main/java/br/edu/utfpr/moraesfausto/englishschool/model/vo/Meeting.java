/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.util.List;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author f4ustx
 */
@Entity
@Table(name="meeting")
public class Meeting {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;

    private String topic;
    
    private ScheduleDays scheduleDay;
    
    private ScheduleMeetingTimes meetingTime;
    
    @OneToMany(mappedBy="meeting")
    private List<Team> teams;
    
    @ElementCollection
    @CollectionTable(name="guests", joinColumns=@JoinColumn(name="guest_meeting_id"))
    @Column(name="guest_name")
    private List<String> guestName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public ScheduleDays getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(ScheduleDays scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public ScheduleMeetingTimes getMeetingTime() {
        return meetingTime;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    
    public void setMeetingTime(ScheduleMeetingTimes meetingTime) {
        this.meetingTime = meetingTime;
    }

    public List<String> getGuestName() {
        return guestName;
    }

    public void setGuestName(List<String> guestName) {
        this.guestName = guestName;
    }

}
