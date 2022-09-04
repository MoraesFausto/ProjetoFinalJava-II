/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Worker;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class WorkerDAOImpl implements WorkerDAO {

      
    EntityManager manager;
    
    public WorkerDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Worker Worker) {
        manager.getTransaction().begin();
        manager.persist(Worker);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Worker Worker) {
        manager.getTransaction().begin();
        manager.merge(Worker);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Worker Worker) {
        manager.getTransaction().begin();
        manager.remove(Worker);
        manager.getTransaction().commit();
    }

    @Override
    public List<Worker> listAll() {
        List<Worker> Workers;
        
        TypedQuery query = manager.createQuery("SELECT c from Worker c", Worker.class);
        Workers = query.getResultList();
        
        return Workers;
    }

    @Override
    public Worker listById(Long id) {
        Worker Worker;
        Query query = manager.createQuery("SELECT c from Worker c WHERE c.id = " + id);
        Worker = (Worker) query.getSingleResult();
        return Worker;
    }

    @Override
    public Worker listByName(String name) {
        Worker Worker;
                                            
        Query query = manager.createQuery("SELECT c FROM Worker c WHERE c.name LIKE '%" + name + "%'");
        Worker = (Worker) query.getSingleResult();
        
        return Worker;
    }
    
}
