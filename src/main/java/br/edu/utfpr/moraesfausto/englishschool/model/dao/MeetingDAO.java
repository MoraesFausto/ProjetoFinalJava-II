/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Meeting;

/**
 *
 * @author f4ustx
 */
public interface MeetingDAO {
        
    void save(Meeting Meeting);
    
    void update(Meeting Meeting);
    
    void delete(Meeting Meeting);
    
    List<Meeting> listAll();
    
    Meeting listById(Long id);
    Meeting listByTitle(String title);
}
