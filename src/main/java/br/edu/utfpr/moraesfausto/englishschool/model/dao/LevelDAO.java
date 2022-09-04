/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Level;

/**
 *
 * @author f4ustx
 */
public interface LevelDAO {
        
    void save(Level Level);
    
    void update(Level Level);
    
    void delete(Level Level);
    
    List<Level> listAll();
    
    Level listById(Long id);
    Level listByTitle(String title);
}
