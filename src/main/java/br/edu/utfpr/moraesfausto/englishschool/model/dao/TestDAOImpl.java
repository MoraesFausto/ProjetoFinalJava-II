/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Test;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class TestDAOImpl implements TestDAO{

    
    EntityManager manager;
    
    public TestDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Test Test) {
        manager.getTransaction().begin();
        manager.persist(Test);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Test Test) {
        manager.getTransaction().begin();
        manager.merge(Test);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Test Test) {
        manager.getTransaction().begin();
        manager.remove(Test);
        manager.getTransaction().commit();
    }

    @Override
    public List<Test> listAll() {
        List<Test> Tests;
        
        TypedQuery query = manager.createQuery("SELECT t from Test t", Test.class);
        Tests = query.getResultList();
        
        return Tests;
    }

    @Override
    public Test listById(Long id) {
        Test Test;
        Query query = manager.createQuery("SELECT t from Test t WHERE t.id = " + id);
        Test = (Test) query.getSingleResult();
        return Test;
    }

    @Override
    public Test listByTitle(String title) {
        Test Test;
                                            
        Query query = manager.createQuery("SELECT t FROM Test t WHERE t.title LIKE '%" + title + "%'");
        Test = (Test) query.getSingleResult();
        
        return Test;
    }
    
}
