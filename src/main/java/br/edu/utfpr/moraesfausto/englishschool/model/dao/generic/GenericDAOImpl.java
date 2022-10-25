/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao.generic;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.HibernateConnection;
import javax.persistence.EntityManager;

/**
 *
 * @author f4ustx
 */
public class GenericDAOImpl<T> implements GenericDAO<T>{

    EntityManager manager;
    
    public GenericDAOImpl(){
        manager = HibernateConnection.getInstance();   
    }
    
    @Override
    public void save(T object) {
         manager.getTransaction().begin();
         manager.persist(object);
         manager.getTransaction().commit();
     } 

    @Override
    public void update(T object) {
        manager.getTransaction().begin();
        manager.merge(object);
        manager.getTransaction().commit();
     }

    @Override
    public void delete(T object) {
        manager.getTransaction().begin();
        manager.remove(object);
        manager.getTransaction().commit();
    }

}
