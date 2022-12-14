/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author f4ustx
 */
@Entity
@Table(name="teacher")
public class Teacher extends Worker {
    
       
    @ManyToOne
    private Team team;
    
    @OneToMany(mappedBy="teacher")
    private List<SchoolClass> schoolClass;

    public Teacher(){
    
    }
    
    public Teacher(Worker worker){
        this.name = worker.getName();
        this.email = worker.getEmail();
        this.password = worker.getPassword();
        this.phone = worker.getPhone();
        this.licenseNumber = worker.getLicenseNumber();
        this.contract = worker.getContract();
        this.active = worker.isActive();
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public List<SchoolClass> getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(List<SchoolClass> schoolClass) {
        this.schoolClass = schoolClass;
    }
    
}