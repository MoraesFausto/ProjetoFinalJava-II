/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Student;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class StudentDAOImpl implements StudentDAO{

       
    EntityManager manager;
    
    public StudentDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Student Student) {
        manager.getTransaction().begin();
        manager.persist(Student);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Student Student) {
        manager.getTransaction().begin();
        manager.merge(Student);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Student Student) {
        manager.getTransaction().begin();
        manager.remove(Student);
        manager.getTransaction().commit();
    }

    @Override
    public List<Student> listAll() {
        List<Student> Students;
        
        TypedQuery query = manager.createQuery("SELECT s from Student s", Student.class);
        Students = query.getResultList();
        
        return Students;
    }

    @Override
    public Student listById(Long id) {
        Student Student;
        Query query = manager.createQuery("SELECT s from Student s WHERE s.id = " + id);
        Student = (Student) query.getSingleResult();
        return Student;
    }

    @Override
    public Student listByName(String name) {
        Student Student;
                                            
        Query query = manager.createQuery("SELECT s FROM Student s WHERE c.name LIKE '%" + name + "%'");
        Student = (Student) query.getSingleResult();
        
        return Student;
    }
    
}
