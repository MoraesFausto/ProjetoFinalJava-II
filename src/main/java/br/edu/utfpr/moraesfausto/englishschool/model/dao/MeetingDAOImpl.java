/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Meeting;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class MeetingDAOImpl implements MeetingDAO{


    EntityManager manager;
    
    public MeetingDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Meeting Meeting) {
        manager.getTransaction().begin();
        manager.persist(Meeting);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Meeting Meeting) {
        manager.getTransaction().begin();
        manager.merge(Meeting);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Meeting Meeting) {
        manager.getTransaction().begin();
        manager.remove(Meeting);
        manager.getTransaction().commit();
    }

    @Override
    public List<Meeting> listAll() {
        List<Meeting> Meetings;
        
        TypedQuery query = manager.createQuery("SELECT m from Meeting m", Meeting.class);
        Meetings = query.getResultList();
        
        return Meetings;
    }

    @Override
    public Meeting listById(Long id) {
        Meeting Meeting;
        Query query = manager.createQuery("SELECT m from Meeting m WHERE m.id = " + id);
        Meeting = (Meeting) query.getSingleResult();
        return Meeting;
    }

    @Override
    public Meeting listByTitle(String title) {
        Meeting Meeting;
                                            
        Query query = manager.createQuery("SELECT m FROM Meeting m WHERE m.title LIKE '%" + title + "%'");
        Meeting = (Meeting) query.getSingleResult();
        
        return Meeting;
    }
    
}
