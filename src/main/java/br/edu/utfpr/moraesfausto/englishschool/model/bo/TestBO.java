/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;
import java.util.List;
import org.hibernate.HibernateException;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TestDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.TestDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Test;

/**
 *
 * @author f4ustx
 */
public class TestBO {
    private TestDAO TestDAO;

    public TestBO(TestDAO TestDAO) {
        this.TestDAO = new TestDAOImpl();
    }
    
    public void save(Test Test){
        try{
          TestDAO.save(Test);
        } catch(HibernateException he){
            System.out.println(he);
        }
    }
    public void update(Test Test){
        TestDAO.update(Test);
    }
    public void delete(Test Test){
        TestDAO.delete(Test);
    }
    
    public List<Test> listAll(){
        return TestDAO.listAll();
    }
    
    public Test listById(Long id){
        return TestDAO.listById(id);
    }
    
    public Test listByTitle(String title){
        return TestDAO.listByTitle(title);
    }
}
