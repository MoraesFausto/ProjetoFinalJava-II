/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;
import org.hibernate.HibernateException;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.SubjectDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.SubjectDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Subject;

/**
 *
 * @author f4ustx
 */
public class SubjectBO {
    private SubjectDAO SubjectDAO;

    public SubjectBO(SubjectDAO SubjectDAO) {
        this.SubjectDAO = new SubjectDAOImpl();
    }
    
    public void save(Subject Subject){
        try{
          SubjectDAO.save(Subject);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Subject Subject){
        SubjectDAO.update(Subject);
    }
    public void delete(Subject Subject){
        SubjectDAO.delete(Subject);
    }
    
    public List<Subject> listAll(){
        return SubjectDAO.listAll();
    }
    
    public Subject listById(Long id){
        return SubjectDAO.listById(id);
    }
    
    public Subject listByTitle(String title){
        return SubjectDAO.listByTitle(title);
    }
}
