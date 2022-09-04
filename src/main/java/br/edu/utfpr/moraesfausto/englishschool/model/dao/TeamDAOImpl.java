/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Team;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class TeamDAOImpl implements TeamDAO{

    
    EntityManager manager;
    
    public TeamDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public void save(Team Team) {
        manager.getTransaction().begin();
        manager.persist(Team);
        manager.getTransaction().commit();
    }

    @Override
    public void update(Team Team) {
        manager.getTransaction().begin();
        manager.merge(Team);
        manager.getTransaction().commit();    
    }

    @Override
    public void delete(Team Team) {
        manager.getTransaction().begin();
        manager.remove(Team);
        manager.getTransaction().commit();
    }

    @Override
    public List<Team> listAll() {
        List<Team> Teams;
        
        TypedQuery query = manager.createQuery("SELECT t from Team t", Team.class);
        Teams = query.getResultList();
        
        return Teams;
    }

    @Override
    public Team listById(Long id) {
        Team Team;
        Query query = manager.createQuery("SELECT t from Team b WHERE t.id = " + id);
        Team = (Team) query.getSingleResult();
        return Team;
    }

    @Override
    public Team listByTitle(String title) {
        Team Team;
                                            
        Query query = manager.createQuery("SELECT t FROM Team t WHERE t.title LIKE '%" + title + "%'");
        Team = (Team) query.getSingleResult();
        
        return Team;
    }
    
}
