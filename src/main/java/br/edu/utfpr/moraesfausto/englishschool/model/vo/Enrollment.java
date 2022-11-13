/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.Embeddable;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author f4ustx
 */
@Embeddable
public class Enrollment extends Contract {
    
    private LocalDate extensionExpiringDate;
    private BigDecimal extensionValue;

    
    public LocalDate getExtensionExpiringDate() {
        return extensionExpiringDate;
    }

    public void setExtensionExpiringDate(LocalDate expiringDate) {
        this.extensionExpiringDate = expiringDate;
    }

    public BigDecimal getExtensionValue() {
        return extensionValue;
    }

    public void setVExtensionValue(BigDecimal value) {
        this.extensionValue = value;
    }
    
}
