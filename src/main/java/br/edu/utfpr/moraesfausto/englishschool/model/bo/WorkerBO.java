/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;

import java.util.List;
import org.hibernate.HibernateException;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.WorkerDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.WorkerDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker;

/**
 *
 * @author f4ustx
 */
public class WorkerBO {
    private WorkerDAO WorkerDAO;

    public WorkerBO(WorkerDAO WorkerDAO) {
        this.WorkerDAO = new WorkerDAOImpl();
    }
    
    public void save(Worker Worker){
        try{
          WorkerDAO.save(Worker);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Worker Worker){
        WorkerDAO.update(Worker);
    }
    public void delete(Worker Worker){
        WorkerDAO.delete(Worker);
    }
    
    public List<Worker> listAll(){
        return WorkerDAO.listAll();
    }
    
    public Worker listById(Long id){
        return WorkerDAO.listById(id);
    }
    
    public Worker listByName(String name){
        return WorkerDAO.listByName(name);
    }
}
