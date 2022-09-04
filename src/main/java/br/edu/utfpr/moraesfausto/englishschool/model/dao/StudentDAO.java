/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Student;

/**
 *
 * @author f4ustx
 */
public interface StudentDAO {
        
    void save(Student Student);
    
    void update(Student Student);
    
    void delete(Student Student);
    
    List<Student> listAll();
    
    Student listById(Long id);
    Student listByName(String title);
}
