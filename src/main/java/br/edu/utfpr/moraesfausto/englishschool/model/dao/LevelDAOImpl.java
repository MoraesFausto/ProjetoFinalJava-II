/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Level;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class LevelDAOImpl implements LevelDAO{


    EntityManager manager;
    
    public LevelDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Level Level) {
        manager.getTransaction().begin();
        manager.persist(Level);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Level Level) {
        manager.getTransaction().begin();
        manager.merge(Level);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Level Level) {
        manager.getTransaction().begin();
        manager.remove(Level);
        manager.getTransaction().commit();
    }

    @Override
    public List<Level> listAll() {
        List<Level> Levels;
        
        TypedQuery query = manager.createQuery("SELECT l from Level l", Level.class);
        Levels = query.getResultList();
        
        return Levels;
    }

    @Override
    public Level listById(Long id) {
        Level Level;
        Query query = manager.createQuery("SELECT l from Level l WHERE l.id = " + id);
        Level = (Level) query.getSingleResult();
        return Level;
    }

    @Override
    public Level listByTitle(String title) {
        Level Level;
                                            
        Query query = manager.createQuery("SELECT l FROM Level l WHERE l.title LIKE '%" + title + "%'");
        Level = (Level) query.getSingleResult();
        
        return Level;
    }
    
}
