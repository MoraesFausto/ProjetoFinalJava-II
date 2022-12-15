/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao.generic;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.HibernateConnection;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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

    @Override
    public T listOne(Class clazz, int pkValue) {
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t.id = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        
        return (T) obj;
    }
    
    @Override
    public List<T> listAll(Class clazz){
        List<T> results;
        TypedQuery query = manager.createQuery("SELECT t from " + clazz.getTypeName() + " t", clazz);
        results = query.getResultList();
        return results;
    }
    
    @Override
    public T findOne(Class clazz, String pkName, int pkValue){
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + pkName + " = " + pkValue;
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        
        return (T) obj;
    }
    
    @Override
    public List<Object> findAllBy(Class clazz, String fkName, int fkValue){
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t." + fkName + " = " + fkValue;
        Query query = this.manager.createQuery(jpql);
        List<Object> resultList = query.getResultList();
        
        return resultList;
    }
    
    @Override
    public T findOneByEmail(Class clazz, String fieldValue){
        String jpql = "SELECT t FROM " + clazz.getTypeName() + " t WHERE t.email = '" + fieldValue + "'";
        
        Query query = this.manager.createQuery(jpql);
        Object obj = query.getSingleResult();
        
        return (T) obj;
    }
    
    public void closeDAO(){
        this.manager.close();
    }

}
