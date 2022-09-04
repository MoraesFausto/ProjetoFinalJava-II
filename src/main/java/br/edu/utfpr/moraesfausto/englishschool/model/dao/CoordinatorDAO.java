/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Coordinator;

/**
 *
 * @author f4ustx
 */
public interface CoordinatorDAO {
        
    void save(Coordinator Coordinator);
    
    void update(Coordinator Coordinator);
    
    void delete(Coordinator Coordinator);
    
    List<Coordinator> listAll();
    
    Coordinator listById(Long id);
    Coordinator listByName(String title);
}
