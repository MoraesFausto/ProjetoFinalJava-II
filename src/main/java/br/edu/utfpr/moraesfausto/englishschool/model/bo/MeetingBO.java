/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.MeetingDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.MeetingDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Meeting;


/**
 *
 * @author f4ustx
 */
public class MeetingBO {
    private MeetingDAO MeetingDAO;

    public MeetingBO(MeetingDAO MeetingDAO) {
        this.MeetingDAO = new MeetingDAOImpl();
    }
    
    public void save(Meeting Meeting){
        try{
          MeetingDAO.save(Meeting);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Meeting Meeting){
        MeetingDAO.update(Meeting);
    }
    public void delete(Meeting Meeting){
        MeetingDAO.delete(Meeting);
    }
    
    public List<Meeting> listAll(){
        return MeetingDAO.listAll();
    }
    
    public Meeting listById(Long id){
        return MeetingDAO.listById(id);
    }
    
    public Meeting listByTitle(String title){
        return MeetingDAO.listByTitle(title);
    }
}
