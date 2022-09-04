/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import javax.persistence.ManyToOne;


/**
 *
 * @author f4ustx
 */
@Entity
@Table(name="event")
public class Event {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String title;
    
    private LocalDate firstDay;
    private LocalDate lastDay;
    
    private float budget;
    private float profit;

    @ManyToOne
    private Level level;
    
    @ManyToOne
    private Coordinator coordinator;
}
