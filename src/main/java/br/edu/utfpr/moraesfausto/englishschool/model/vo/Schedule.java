/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.persistence.Embeddable;

/**
 *
 * @author f4ustx
 */
@Embeddable
public class Schedule {

    private ScheduleDays scheduleDay;
    
    private ScheduleTimes scheduleTime;

    public ScheduleDays getScheduleDay() {
        return scheduleDay;
    }

    public void setScheduleDay(ScheduleDays scheduleDay) {
        this.scheduleDay = scheduleDay;
    }

    public ScheduleTimes getScheduleTime() {
        return scheduleTime;
    }

    public void setScheduleTime(ScheduleTimes scheduleTime) {
        this.scheduleTime = scheduleTime;
    }

}
