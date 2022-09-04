/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Coordinator;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class CoordinatorDAOImpl implements CoordinatorDAO {

   
    EntityManager manager;
    
    public CoordinatorDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Coordinator Coordinator) {
        manager.getTransaction().begin();
        manager.persist(Coordinator);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Coordinator Coordinator) {
        manager.getTransaction().begin();
        manager.merge(Coordinator);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Coordinator Coordinator) {
        manager.getTransaction().begin();
        manager.remove(Coordinator);
        manager.getTransaction().commit();
    }

    @Override
    public List<Coordinator> listAll() {
        List<Coordinator> Coordinators;
        
        TypedQuery query = manager.createQuery("SELECT c from Coordinator c", Coordinator.class);
        Coordinators = query.getResultList();
        
        return Coordinators;
    }

    @Override
    public Coordinator listById(Long id) {
        Coordinator Coordinator;
        Query query = manager.createQuery("SELECT c from Coordinator c WHERE c.id = " + id);
        Coordinator = (Coordinator) query.getSingleResult();
        return Coordinator;
    }

    @Override
    public Coordinator listByName(String name) {
        Coordinator Coordinator;
                                            
        Query query = manager.createQuery("SELECT c FROM Coordinator c WHERE c.name LIKE '%" + name + "%'");
        Coordinator = (Coordinator) query.getSingleResult();
        
        return Coordinator;
    }
    
}
