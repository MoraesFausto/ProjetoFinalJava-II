/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Grade;

/**
 *
 * @author f4ustx
 */
public interface GradeDAO {
        
    void save(Grade Grade);
    
    void update(Grade Grade);
    
    void delete(Grade Grade);
    
    List<Grade> listAll();
    
    Grade listById(Long id);
}
