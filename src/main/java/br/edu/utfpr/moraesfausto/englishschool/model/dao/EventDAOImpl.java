/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Event;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class EventDAOImpl implements EventDAO{

    
    EntityManager manager;
    
    public EventDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Event Event) {
        manager.getTransaction().begin();
        manager.persist(Event);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Event Event) {
        manager.getTransaction().begin();
        manager.merge(Event);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Event Event) {
        manager.getTransaction().begin();
        manager.remove(Event);
        manager.getTransaction().commit();
    }

    @Override
    public List<Event> listAll() {
        List<Event> Events;
        
        TypedQuery query = manager.createQuery("SELECT e from Event e", Event.class);
        Events = query.getResultList();
        
        return Events;
    }

    @Override
    public Event listById(Long id) {
        Event Event;
        Query query = manager.createQuery("SELECT e from Event e WHERE e.id = " + id);
        Event = (Event) query.getSingleResult();
        return Event;
    }

    @Override
    public Event listByTitle(String title) {
        Event Event;
                                            
        Query query = manager.createQuery("SELECT e FROM Event e WHERE e.title LIKE '%" + title + "%'");
        Event = (Event) query.getSingleResult();
        
        return Event;
    }
    
}
