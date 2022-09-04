/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.vo;

/**
 *
 * @author f4ustx
 */
public enum ScheduleTimes {
   FIRST_CLASS(8),
   SECOND_CLASS(9),
   THIRD_CLASS(10),
   FOURTH_CLASS(11),
   
   FIFTH_CLASS(13),
   SIXTH_CLASS(14),
   SEVENTH_CLASS(15),
   EIGHTH_CLASS(16),
   
   NINETH_CLASS(19),
   TENTH_CLASS(20);
   
   private int value;
   
    private ScheduleTimes(int value) {
        this.value = value;
    }
    
}
