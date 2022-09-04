/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.EventDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.EventDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Event;

/**
 *
 * @author f4ustx
 */
public class EventBO {
       private EventDAO EventDAO;

    public EventBO(EventDAO EventDAO) {
        this.EventDAO = new EventDAOImpl();
    }
    
    public void save(Event Event){
        try{
          EventDAO.save(Event);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Event Event){
        EventDAO.update(Event);
    }
    public void delete(Event Event){
        EventDAO.delete(Event);
    }
    
    public List<Event> listAll(){
        return EventDAO.listAll();
    }
    
    public Event listById(Long id){
        return EventDAO.listById(id);
    }
    
    public Event listByTitle(String title){
        return EventDAO.listByTitle(title);
    }
    
}
