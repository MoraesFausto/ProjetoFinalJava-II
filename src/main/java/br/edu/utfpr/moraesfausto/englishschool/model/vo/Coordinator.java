/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author f4ustx
 */
@Entity
@Table(name = "coordinator")
public class Coordinator extends Worker {
    
    @OneToMany(mappedBy="coordinator")
    private List<Event> events;
    
    @OneToMany(mappedBy="coordinator")
    private List<Team> teams;

    public Coordinator(){
    
    }
    
    public Coordinator(Worker worker) {
        this.name = worker.getName();
        this.password = worker.getPassword();
        this.phone = worker.getPhone();
        this.licenseNumber = worker.getLicenseNumber();
        this.contract = worker.getContract();
        this.active = worker.isActive();
    }


    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
    
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
    
}
