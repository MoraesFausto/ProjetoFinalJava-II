/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Embeddable;


/**
 *
 * @author f4ustx
 */
@Embeddable
public class Contract {
   
    private String description;
    private int yearsLeft;
    private float value;
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setYearsLeft(int years){
        this.yearsLeft = years;
    }
    
    int getYearsLeft(){
        return this.yearsLeft;
    }

    public float getValue() {
        return this.value;
    }

    public void setValue(float value) {
        this.value = value;
    }   
    
}
