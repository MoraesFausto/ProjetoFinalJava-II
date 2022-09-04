/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;

import org.hibernate.HibernateException;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.StudentDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.StudentDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Student;

/**
 *
 * @author f4ustx
 */
public class StudentBO {
    private StudentDAO StudentDAO;

    public StudentBO(StudentDAO StudentDAO) {
        this.StudentDAO = new StudentDAOImpl();
    }
    
    public void save(Student Student){
        try{
          StudentDAO.save(Student);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Student Student){
        StudentDAO.update(Student);
    }
    public void delete(Student Student){
        StudentDAO.delete(Student);
    }
    
    public List<Student> listAll(){
        return StudentDAO.listAll();
    }
    
    public Student listById(Long id){
        return StudentDAO.listById(id);
    }
    
    public Student listByName(String name){
        return StudentDAO.listByName(name);
    }   
}
