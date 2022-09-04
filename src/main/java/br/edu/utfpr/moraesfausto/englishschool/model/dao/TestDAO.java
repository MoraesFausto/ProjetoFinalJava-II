/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Test;

/**
 *
 * @author f4ustx
 */
public interface TestDAO {
        
    void save(Test Test);
    
    void update(Test Test);
    
    void delete(Test Test);
    
    List<Test> listAll();
    
    Test listById(Long id);
    Test listByTitle(String title);
}
