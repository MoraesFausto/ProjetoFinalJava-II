/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Teacher;

/**
 *
 * @author f4ustx
 */
public interface TeacherDAO {
        
    void save(Teacher Teacher);
    
    void update(Teacher Teacher);
    
    void delete(Teacher Teacher);
    
    List<Teacher> listAll();
    
    Teacher listById(Long id);
    Teacher listByName(String title);
}
