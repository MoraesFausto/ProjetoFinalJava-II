/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.LevelDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.LevelDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Level;

/**
 *
 * @author f4ustx
 */
public class LevelBO {
    private LevelDAO LevelDAO;

    public LevelBO(LevelDAO LevelDAO) {
        this.LevelDAO = new LevelDAOImpl();
    }
    
    public void save(Level Level){
        try{
          LevelDAO.save(Level);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Level Level){
        LevelDAO.update(Level);
    }
    public void delete(Level Level){
        LevelDAO.delete(Level);
    }
    
    public List<Level> listAll(){
        return LevelDAO.listAll();
    }
    
    public Level listById(Long id){
        return LevelDAO.listById(id);
    }
    
    public Level listByTitle(String title){
        return LevelDAO.listByTitle(title);
    }
}
