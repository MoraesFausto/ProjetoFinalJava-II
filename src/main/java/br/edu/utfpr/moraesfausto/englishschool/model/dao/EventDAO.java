/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Event;

/**
 *
 * @author f4ustx
 */
public interface EventDAO {
        
    void save(Event Event);
    
    void update(Event Event);
    
    void delete(Event Event);
    
    List<Event> listAll();
    
    Event listById(Long id);
    Event listByTitle(String title);
}
