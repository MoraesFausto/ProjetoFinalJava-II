/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Teacher;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class TeacherDAOImpl implements TeacherDAO{

      
    EntityManager manager;
    
    public TeacherDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Teacher Teacher) {
        manager.getTransaction().begin();
        manager.persist(Teacher);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Teacher Teacher) {
        manager.getTransaction().begin();
        manager.merge(Teacher);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Teacher Teacher) {
        manager.getTransaction().begin();
        manager.remove(Teacher);
        manager.getTransaction().commit();
    }

    @Override
    public List<Teacher> listAll() {
        List<Teacher> Teachers;
        
        TypedQuery query = manager.createQuery("SELECT t from Teacher t", Teacher.class);
        Teachers = query.getResultList();
        
        return Teachers;
    }

    @Override
    public Teacher listById(Long id) {
        Teacher Teacher;
        Query query = manager.createQuery("SELECT p from Teacher t WHERE t.id = " + id);
        Teacher = (Teacher) query.getSingleResult();
        return Teacher;
    }

    @Override
    public Teacher listByName(String name) {
        Teacher Teacher;
                                            
        Query query = manager.createQuery("SELECT c FROM Teacher t WHERE t.name LIKE '%" + name + "%'");
        Teacher = (Teacher) query.getSingleResult();
        
        return Teacher;
    }
    
}
