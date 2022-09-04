/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Subject;

/**
 *
 * @author f4ustx
 */
public interface SubjectDAO {
        
    void save(Subject Subject);
    
    void update(Subject Subject);
    
    void delete(Subject Subject);
    
    List<Subject> listAll();
    
    Subject listById(Long id);
    Subject listByTitle(String title);
}
