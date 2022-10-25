/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo;

import br.edu.utfpr.moraesfausto.englishschool.model.dao.BookDAO;
import br.edu.utfpr.moraesfausto.englishschool.model.dao.BookDAOImpl;
import br.edu.utfpr.moraesfausto.englishschool.model.vo.Book;
import java.util.List;
import org.hibernate.HibernateException;

/**
 *
 * @author f4ustx
 */
public class BookBO {
    private BookDAO bookDAO;

    public BookBO(BookDAO bookDAO) {
        this.bookDAO = new BookDAOImpl();
    }
    
    public List<Book> listAll(){
        return bookDAO.listAll();
    }
    
    public Book listById(Long id){
        if(id == null)
            throw new IllegalArgumentException("Id cannot be null");
        return bookDAO.listById(id);
    }
    
    public Book listByTitle(String title){
        if(title.length() <= 0)
            throw new IllegalArgumentException("Title cannot be empty");
        return bookDAO.listByTitle(title);
    }
    
}
