/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.SchoolClassDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.SchoolClassDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.SchoolClass;


/**
 *
 * @author f4ustx
 */
public class SchoolClassBO {
    private SchoolClassDAO SchoolClassDAO;

    public SchoolClassBO(SchoolClassDAO SchoolClassDAO) {
        this.SchoolClassDAO = new SchoolClassDAOImpl();
    }
    
    public void save(SchoolClass SchoolClass){
        try{
          SchoolClassDAO.save(SchoolClass);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(SchoolClass SchoolClass){
        SchoolClassDAO.update(SchoolClass);
    }
    public void delete(SchoolClass SchoolClass){
        SchoolClassDAO.delete(SchoolClass);
    }
    
    public List<SchoolClass> listAll(){
        return SchoolClassDAO.listAll();
    }
    
    public SchoolClass listById(Long id){
        return SchoolClassDAO.listById(id);
    }
    
    public SchoolClass listByTitle(String title){
        return SchoolClassDAO.listByTitle(title);
    }
}
