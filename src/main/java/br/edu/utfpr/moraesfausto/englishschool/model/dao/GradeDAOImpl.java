/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Grade;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class GradeDAOImpl implements GradeDAO {

    EntityManager manager;
    
    public GradeDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Grade Grade) {
        manager.getTransaction().begin();
        manager.persist(Grade);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Grade Grade) {
        manager.getTransaction().begin();
        manager.merge(Grade);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Grade Grade) {
        manager.getTransaction().begin();
        manager.remove(Grade);
        manager.getTransaction().commit();
    }

    @Override
    public List<Grade> listAll() {
        List<Grade> Grades;
        
        TypedQuery query = manager.createQuery("SELECT p from Grade p", Grade.class);
        Grades = query.getResultList();
        
        return Grades;
    }

    @Override
    public Grade listById(Long id) {
        Grade Grade;
        Query query = manager.createQuery("SELECT p from Grade p WHERE p.id = " + id);
        Grade = (Grade) query.getSingleResult();
        return Grade;
    }
}
