/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.SchoolClass;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class SchoolClassDAOImpl implements SchoolClassDAO{

    
    EntityManager manager;
    
    public SchoolClassDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(SchoolClass SchoolClass) {
        manager.getTransaction().begin();
        manager.persist(SchoolClass);
        manager.getTransaction().commit();
    }

    @Override
    public void update(SchoolClass SchoolClass) {
        manager.getTransaction().begin();
        manager.merge(SchoolClass);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(SchoolClass SchoolClass) {
        manager.getTransaction().begin();
        manager.remove(SchoolClass);
        manager.getTransaction().commit();
    }

    @Override
    public List<SchoolClass> listAll() {
        List<SchoolClass> SchoolClasss;
        
        TypedQuery query = manager.createQuery("SELECT s from SchoolClass s", SchoolClass.class);
        SchoolClasss = query.getResultList();
        
        return SchoolClasss;
    }

    @Override
    public SchoolClass listById(Long id) {
        SchoolClass SchoolClass;
        Query query = manager.createQuery("SELECT s from SchoolClass s WHERE s.id = " + id);
        SchoolClass = (SchoolClass) query.getSingleResult();
        return SchoolClass;
    }

    @Override
    public SchoolClass listByTitle(String title) {
        SchoolClass SchoolClass;
                                            
        Query query = manager.createQuery("SELECT s FROM SchoolClass s WHERE s.title LIKE '%" + title + "%'");
        SchoolClass = (SchoolClass) query.getSingleResult();
        
        return SchoolClass;
    }
    
}
