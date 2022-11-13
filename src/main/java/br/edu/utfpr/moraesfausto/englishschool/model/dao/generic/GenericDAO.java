/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.dao.generic;

/**
 *
 * @author f4ustx
 */
public interface GenericDAO<T> {
    void save(T object);
    void update(T object);
    void delete(T object);
    T listOne(int pkValue, Class clazz);
}
