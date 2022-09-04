/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Payment;

/**
 *
 * @author f4ustx
 */
public interface PaymentDAO {
        
    void save(Payment Payment);
    
    void update(Payment Payment);
    
    void delete(Payment Payment);
    
    List<Payment> listAll();
    
    Payment listById(Long id);
}
