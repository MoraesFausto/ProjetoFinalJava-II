/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Subject;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class SubjectDAOImpl implements SubjectDAO{


    EntityManager manager;
    
    public SubjectDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Subject Subject) {
        manager.getTransaction().begin();
        manager.persist(Subject);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Subject Subject) {
        manager.getTransaction().begin();
        manager.merge(Subject);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Subject Subject) {
        manager.getTransaction().begin();
        manager.remove(Subject);
        manager.getTransaction().commit();
    }

    @Override
    public List<Subject> listAll() {
        List<Subject> Subjects;
        
        TypedQuery query = manager.createQuery("SELECT s from Subject s", Subject.class);
        Subjects = query.getResultList();
        
        return Subjects;
    }

    @Override
    public Subject listById(Long id) {
        Subject Subject;
        Query query = manager.createQuery("SELECT s from Subject s WHERE s.id = " + id);
        Subject = (Subject) query.getSingleResult();
        return Subject;
    }

    @Override
    public Subject listByTitle(String title) {
        Subject Subject;
                                            
        Query query = manager.createQuery("SELECT s FROM Subject s WHERE s.title LIKE '%" + title + "%'");
        Subject = (Subject) query.getSingleResult();
        
        return Subject;
    }
    
}
