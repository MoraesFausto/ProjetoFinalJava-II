/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import java.util.List;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker;

/**
 *
 * @author f4ustx
 */
public interface WorkerDAO {
        
    void save(Worker Worker);
    
    void update(Worker Worker);
    
    void delete(Worker Worker);
    
    List<Worker> listAll();
    
    Worker listById(Long id);
    Worker listByName(String title);
}
