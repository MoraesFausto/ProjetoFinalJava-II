/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.generic.GenericDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Level;

/**
 *
 * @author f4ustx
 */
public class LevelBO {
    private GenericDAO<Level> LevelDAO;

    public LevelBO() {
        this.LevelDAO = new GenericDAOImpl();
    }
    
    public void save(Level level){
        try{
          LevelDAO.save(level);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Level level){
        try{
            LevelDAO.update(level);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void delete(Level level){
        try{
            LevelDAO.delete(level);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }

}
