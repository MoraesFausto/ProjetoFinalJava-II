/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;

import java.util.List;
import org.hibernate.HibernateException;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TeacherDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TeacherDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Teacher;

/**
 *
 * @author f4ustx
 */
public class TeacherBO {
    private TeacherDAO TeacherDAO;

    public TeacherBO() {
        this.TeacherDAO = new TeacherDAOImpl();
    }
    
    public void save(Teacher Teacher){
        try{
          TeacherDAO.save(Teacher);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Teacher Teacher){
        TeacherDAO.update(Teacher);
    }
    public void delete(Teacher Teacher){
        TeacherDAO.delete(Teacher);
    }
    
    public List<Teacher> listAll(){
        return TeacherDAO.listAll();
    }
    
    public Teacher listById(Long id){
        return TeacherDAO.listById(id);
    }
    
    public Teacher listByName(String name){
        return TeacherDAO.listByName(name);
    }
}
