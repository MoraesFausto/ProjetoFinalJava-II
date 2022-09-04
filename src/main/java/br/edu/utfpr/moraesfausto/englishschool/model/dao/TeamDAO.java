/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Team;

/**
 *
 * @author f4ustx
 */
public interface TeamDAO {
        
    void save(Team Team);
    
    void update(Team Team);
    
    void delete(Team Team);
    
    List<Team> listAll();
    
    Team listById(Long id);
    Team listByTitle(String title);
}
