/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao;

import br.edu.utfpr.moraesfausto.englishschool.model.vo.Book;
import java.util.List;

/**
 *
 * @author f4ustx
 */
public interface BookDAO {
    
    void save(Book book);
    
    void update(Book book);
    
    void delete(Book book);
    
    List<Book> listAll();
    
    Book listById(Long id);
    Book listByTitle(String title);

}
