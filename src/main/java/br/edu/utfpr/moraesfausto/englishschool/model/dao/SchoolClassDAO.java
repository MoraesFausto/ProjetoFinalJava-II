/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.SchoolClass;

/**
 *
 * @author f4ustx
 */
public interface SchoolClassDAO {
        
    void save(SchoolClass SchoolClass);
    
    void update(SchoolClass SchoolClass);
    
    void delete(SchoolClass SchoolClass);
    
    List<SchoolClass> listAll();
    
    SchoolClass listById(Long id);
    SchoolClass listByTitle(String title);
}
