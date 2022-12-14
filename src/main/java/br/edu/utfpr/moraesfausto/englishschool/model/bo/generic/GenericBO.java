/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.utfpr.moraesfausto.englishschool.model.bo.generic;

import java.util.List;

/**
 *
 * @author f4ustx
 */
public interface GenericBO<T> {
    void save(T object);
    void update(T object);
    void delete(T object);
    T listOne(Class clazz, int pkValue);
    List<T> listAll(Class clazz);
    T findOne(Class clazz, String pkName, int pkValue);
    List<Object> findAllBy(Class clazz, String fkName, int fkValue);
    T findOneByEmail(Class clazz, String fieldValue);
}
