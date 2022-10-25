/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Book;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author f4ustx
 */
public class BookDAOImpl implements BookDAO{

    EntityManager manager;
    
    public BookDAOImpl(){
        this.manager = HibernateConnection.getInstance();
    }
    
    @Override
    public List<Book> listAll() {
        List<Book> Books;
        
        TypedQuery query = manager.createQuery("SELECT b from Book b", Book.class);
        Books = query.getResultList();
        
        return Books;
    }

    @Override
    public Book listById(Long id) {
        Book Book;
        Query query = manager.createQuery("SELECT b from Book b WHERE b.id = " + id);
        Book = (Book) query.getSingleResult();
        return Book;
    }

    @Override
    public Book listByTitle(String title) {
        Book Book;
                                            
        Query query = manager.createQuery("SELECT b FROM Book b WHERE b.title LIKE '%" + title + "%'");
        Book = (Book) query.getSingleResult();
        
        return Book;
    }
    
}
